package com.fxx.springboot.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午1:38:54 
*/
public class PublishMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher publisher = context.getBean(DemoPublisher.class);
		publisher.publish("发送人造卫星！");
		context.close();
	}
}

