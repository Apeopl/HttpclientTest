package com.fxx.springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fxx.springboot.config.ElConfig;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午11:16:43 
*/
public class ResouceMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
		ElConfig bean = context.getBean(ElConfig.class);
		bean.outputResource();
		context.close();
	}

}

