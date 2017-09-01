package com.fxx.springboot.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:37:24 
*/
public class SchedulerMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
		context.getBean(SchedulerTaskService.class);
	}
}

