package com.fxx.springboot.service;

import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:10:25 
*/
@Service
public class DemoMethodService {
	public void add(){
		System.out.println("方法拦截");
	}
}

