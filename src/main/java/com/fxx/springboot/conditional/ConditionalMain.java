package com.fxx.springboot.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:51:54 
*/
public class ConditionalMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);
		ListService listService = context.getBean(ListService.class);
		System.out.println(context.getEnvironment().getProperty("os.name")+"的命令是："+listService.showListCmd());
		context.close();
	}
}

