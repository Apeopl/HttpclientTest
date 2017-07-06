package com.zjl.excise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HashTest {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("java.util.HashMap");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("===========================================");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
