package com.example.clientservice.service;

import com.example.clientservice.schema.User;

public interface UserService {
	//查询一个用户
	User findOneUser(Integer id);
}
