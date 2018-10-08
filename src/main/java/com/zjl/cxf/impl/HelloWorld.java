package com.zjl.cxf.impl;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年1月3日 下午4:39:49 
*/
@WebService
public interface HelloWorld {
	 String sayHi(@WebParam(name="text")String text);
     String sayHiToUser(User user);
     String[] SayHiToUserList(List<User> userList);
}

