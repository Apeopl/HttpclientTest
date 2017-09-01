package com.fxx.springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fxx.springboot.config.ScopeConfig;
import com.fxx.springboot.service.DemoPrototype;
import com.fxx.springboot.service.DemoSingleton;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:46:29 
*/
public class ScopeMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoSingleton single1 = context.getBean(DemoSingleton.class);
		DemoSingleton single2 = context.getBean(DemoSingleton.class);
		DemoPrototype proto1 = context.getBean(DemoPrototype.class);
		DemoPrototype proto2 = context.getBean(DemoPrototype.class);
		System.out.println(single1+":"+single2);
		System.out.println(proto1+":"+proto2);
	}
}

