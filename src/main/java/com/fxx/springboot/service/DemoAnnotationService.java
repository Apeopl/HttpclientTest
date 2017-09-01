package com.fxx.springboot.service;

import org.springframework.stereotype.Service;

import com.fxx.springboot.anno.Action;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:09:08 
*/
@Service
public class DemoAnnotationService {
	@Action(name = "注解式拦截的add操作")
	public void add(){
		System.out.println("注解拦截");
	}
}

