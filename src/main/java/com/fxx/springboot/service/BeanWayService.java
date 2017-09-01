package com.fxx.springboot.service;
/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午11:31:14 
*/

public class BeanWayService {
	public void init(){
		System.out.println("@bean-init-method");
	}
	public BeanWayService(){
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
	public void destory(){
		System.out.println("@bean-destory-method");
	}
}

