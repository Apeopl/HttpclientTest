package com.zjl.excise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ProxyTest {
	public static void main(String[] args) throws Exception{
		//HelloService he = new HelloServiceImpl();
		Properties properties = System.getProperties();
		//System.out.println(System.lineSeparator());
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
		/*Set<Entry<Object,Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}*/
		/*HelloProxy hp = new HelloProxy();
		HelloService he = (HelloService) hp.bind(new HelloServiceImpl());
		he.sayHello("郑金磊");*/
		Class proxyClazz = Proxy.getProxyClass(HelloService.class.getClassLoader(), HelloService.class);
		Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
		HelloService proxy = (HelloService) constructor.newInstance(new HelloProxy(new HelloServiceImpl()));
		proxy.sayHello("老狼");
	}
}
