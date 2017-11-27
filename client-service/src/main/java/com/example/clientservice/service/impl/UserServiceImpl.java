package com.example.clientservice.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.example.clientservice.schema.User;
import com.example.clientservice.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//spring jdbc 
	@Override
	public User findOneUser(Integer id){
		String sql = "select user_name,pwd,mobile_phone,address,role,note from t_user where id = ?";
		final User user = new User();
		jdbcTemplate.query(sql, new Object[]{id},new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(id);
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("pwd"));
				user.setMobilePhone(rs.getString("mobile_phone"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getInt("role"));
				user.setNote(rs.getString("note"));
			}
		});
		
		return user;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
