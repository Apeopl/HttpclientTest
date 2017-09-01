package com.fxx.springboot.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:15:33 
*/
public class AwareMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		context.close();
	}
}

