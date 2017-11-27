package com.example.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * 主类中加上此注解@EnableDiscoveryClient，激活Eureka中的DiscoveryClient实现（自动化配置，创建
 * DiscoveryClient接口针对Eureka客户端的EnableDiscoveryClient实例），才能实现Controller中对服务信息的
 * 输出
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}
}
