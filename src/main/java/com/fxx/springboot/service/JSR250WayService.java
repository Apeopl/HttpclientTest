package com.fxx.springboot.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午11:33:28 
*/
public class JSR250WayService {
	@PostConstruct
	public void init(){
		System.out.println("jsr250-init-method");
	}
	public JSR250WayService(){
		super();
		System.out.println("构造函数初始化-JSR250WayService");
	}
	@PreDestroy
	public void destory(){
		System.out.println("jsr250-destory-method");
	}
}

