package com.fxx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fxx.springboot.service.FunctionService;
import com.fxx.springboot.service.UseFunctionService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月18日 下午5:03:38 
*/
@Configuration
@ComponentScan("com.fxx.springboot.service")
public class BootConfig {
	/*@Bean
	public FunctionService functionService(){
		return new FunctionService();
	}
	@Bean
	public UseFunctionService useFunctionService(){
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}*/
}

