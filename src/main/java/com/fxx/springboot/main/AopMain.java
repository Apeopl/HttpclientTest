package com.fxx.springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fxx.springboot.config.AOPConfig;
import com.fxx.springboot.service.DemoAnnotationService;
import com.fxx.springboot.service.DemoMethodService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:24:57 
*/
public class AopMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		DemoAnnotationService anno = context.getBean(DemoAnnotationService.class);
		DemoMethodService method = context.getBean(DemoMethodService.class);
		anno.add();
		method.add();
		context.close();
	}

}

