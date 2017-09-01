package com.fxx.springboot.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:49:15 
*/
@Configuration
public class ConditionalConfig {
	@Bean
	@Conditional(WindowsConditional.class)
	public ListService windowsListService(){
		return new WindowsListService();
	}
	@Bean
	@Conditional(LinuxConditional.class)
	public ListService linuxListService(){
		return new LinuxListService();
	}
}

