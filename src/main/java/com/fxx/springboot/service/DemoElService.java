package com.fxx.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:58:52 
*/
@Service
public class DemoElService {
	@Value(value = "其他类的属性")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}
	
}

