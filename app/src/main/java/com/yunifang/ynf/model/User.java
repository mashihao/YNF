package com.yunifang.ynf.model;

import cn.bmob.v3.BmobUser;
@SuppressWarnings("serial")
public class User extends BmobUser {
	private String address;
	private Boolean sex;
	private Integer id;

	private String name;
	private String age;
	
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
