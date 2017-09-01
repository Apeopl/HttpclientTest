package com.fxx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fxx.springboot.service.BeanWayService;
import com.fxx.springboot.service.JSR250WayService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午11:36:13 
*/
@Configuration
@ComponentScan("com.fxx.springboot.service")
public class PrePostConfig {
	@Bean(initMethod="init",destroyMethod="destory")
	BeanWayService beanWayService(){
		return new BeanWayService();
	}
	@Bean
	JSR250WayService jSR250WayService(){
		return new JSR250WayService();
	}
}

