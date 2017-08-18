package com.fxx.springboot.service;

import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月18日 下午4:55:03 
*/
@Service
public class FunctionService {
	public String sayHello(String word){
		return "hello "+word;
	}
}

