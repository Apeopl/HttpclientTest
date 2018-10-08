package com.zjl.cxf.impl.app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.zjl.cxf.impl.HelloWorld;
import com.zjl.cxf.impl.service.HelloWorldImpl;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年1月3日 下午4:44:52 
*/
public class WebServiceApp {

	public static void main(String[] args) {
		System.out.println("Server is starting...");  
		HelloWorldImpl readerService = new HelloWorldImpl();  
        Endpoint.publish("http://localhost:8080/readerService",readerService);  
        System.out.println("Server is started...");
	}

}

