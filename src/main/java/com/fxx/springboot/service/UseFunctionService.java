package com.fxx.springboot.service;
/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月18日 下午4:59:26 
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UseFunctionService {
	@Autowired
	private FunctionService functionService;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public String sayHello(String word){
		return functionService.sayHello(word);
	}
}

