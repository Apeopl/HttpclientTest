package com.fxx.springboot.conditional;
/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:48:45 
*/
public class LinuxListService implements ListService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}

