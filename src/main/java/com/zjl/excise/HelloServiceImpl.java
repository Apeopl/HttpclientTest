package com.zjl.excise;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.println("你好！动态代理！"+name);
	}

}
