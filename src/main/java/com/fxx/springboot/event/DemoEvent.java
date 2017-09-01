package com.fxx.springboot.event;

import org.springframework.context.ApplicationEvent;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午1:28:37 
*/
public class DemoEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

