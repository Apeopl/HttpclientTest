package com.fxx.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:22:28 
*/
@Configuration
@ComponentScan("com.fxx.springboot")
@EnableAspectJAutoProxy
public class AOPConfig {

}

