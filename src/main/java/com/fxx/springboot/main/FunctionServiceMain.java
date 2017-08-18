	package com.fxx.springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fxx.springboot.config.BootConfig;
import com.fxx.springboot.service.UseFunctionService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月18日 下午5:06:05 
*/
public class FunctionServiceMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BootConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.sayHello("fxx"));
		context.close();
	}
}

