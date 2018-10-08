package com.zjl.cxf.impl;

import java.io.Serializable;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年1月3日 下午4:42:49 
*/
public class User implements Serializable{
	private String name;
	private String age;
	
	public User() {
	}
	
	public User(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}

