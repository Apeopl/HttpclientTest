package com.fxx.springboot.fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午3:23:09 
*/
@Configuration
public class TestConfig {
	@Bean
	@Profile("dev")
	public TestBean devTestBean(){
		return new TestBean("develop");
	}
	
	@Bean
	@Profile("prod")
	public TestBean prodTestBean(){
		return new TestBean("production");
	}
}

