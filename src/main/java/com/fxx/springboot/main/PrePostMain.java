package com.fxx.springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fxx.springboot.config.PrePostConfig;
import com.fxx.springboot.service.BeanWayService;
import com.fxx.springboot.service.JSR250WayService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午11:38:31 
*/
public class PrePostMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		context.getBean(JSR250WayService.class);
		context.getBean(BeanWayService.class);
		context.close();
	}

}

