package com.zjl.excise;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayToMapTest {
	public static void main(String[] args) {
		String[][] arr2 = {{"a","aaaa"},{"b","bbbb"},{"c","cccc"},{"d","dddd"}};
		Map<Object, Object> map = ArrayUtils.toMap(arr2);
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
	}
}
