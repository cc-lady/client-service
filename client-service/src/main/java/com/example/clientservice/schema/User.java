package com.example.clientservice.schema;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	//编号
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String password;
	//电话
	private String mobilePhone;
	//地址
	private String address;
	//角色
	private Integer role;
	//备注
	private String note;
	public User(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
