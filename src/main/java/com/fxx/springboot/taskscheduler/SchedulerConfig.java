package com.fxx.springboot.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:36:36 
*/
@Configuration
@ComponentScan("com.fxx.springboot.taskscheduler")
@EnableScheduling
public class SchedulerConfig {

}

