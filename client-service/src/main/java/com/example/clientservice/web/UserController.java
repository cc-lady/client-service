package com.example.clientservice.web;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientservice.schema.User;
import com.example.clientservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaClientConfig;


@RestController
@RequestMapping(value="/user")
public class UserController {
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DiscoveryClient client;//注入DiscoveryClient对象，打印出服务相关内容
	
	//private RibbonEurekaAutoConfiguration configuration;
	//==========================学习源码时的测试内容  start==================================
	
	@Autowired
	private EurekaClientConfig clientConfig;
	
	@Autowired
	private EurekaClientConfigBean clientConfigBean;
	
	@RequestMapping("/test")
	public String test() {
		return "Region-"+clientConfig.getRegion()+", zone-"+clientConfigBean.getServiceUrl();
	}
	//============================学习源码时的测试内容  end=========================================
	
	@RequestMapping("/hello")
	public String greet() {
		ServiceInstance instance = client.getLocalServiceInstance();
		//打印服务相关内容
		logger.info("/hello,host:"+instance.getHost()+", service_id:"+instance.getServiceId());
		return "Hello";
	}
	
	@RequestMapping("/hello1")
	public String greet1() throws InterruptedException {
		ServiceInstance instance = client.getLocalServiceInstance();
		//让线程等待几秒
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:"+sleepTime);
		Thread.sleep(sleepTime);
		//打印服务相关内容
		logger.info("/hello,host:"+instance.getHost()+", service_id:"+instance.getServiceId());
		return "Hello";
	}

	@RequestMapping("/findOneUser")
	public String getOneUser() throws JsonProcessingException {
		User user = userService.findOneUser(1);
		//jackson2转化对象为json
		ObjectMapper mapper = new ObjectMapper();          
		// Convert object to JSON string  
		String json =  mapper.writeValueAsString(user);
		
		
		return json;
	}
	
	//=======================以下为学习ribbon调用方法部分====================================
	@RequestMapping("/findUser") 
	public User findUser(Integer id){
		
		User user = userService.findOneUser(id);
		return user;
	}
	
	@RequestMapping("/findUserName")
	public String findUserName(User user) {
		
		return "cc-->"+user.toString();
	}
	//========================以上为学习ribbon调用方法部分===================================
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public EurekaClientConfig getClientConfig() {
		return clientConfig;
	}

	public void setClientConfig(EurekaClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}
	
}
