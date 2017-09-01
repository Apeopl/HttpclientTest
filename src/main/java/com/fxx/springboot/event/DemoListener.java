package com.fxx.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午1:30:41 
*/
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

	@Override
	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("监听器接收到了："+msg);
	}

}

