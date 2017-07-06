package com.zjl.excise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy implements InvocationHandler{

	private Object target;
	
	public HelloProxy(Object target){
		this.target = target;
	}
	
	public Object bind(Object target){
		this.target = target;
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//Object object = method.invoke(target, args);
		System.out.println("来一份大盘鸡");
		return null;
	}

}
