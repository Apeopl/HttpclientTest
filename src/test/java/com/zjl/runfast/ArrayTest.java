package com.zjl.runfast;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTest {
	public static void main(String[] args) {
		String[] strArr = {"a","b","c","d"};
		String[] strArrCopy = new String[5];
		System.arraycopy(strArr, 0, strArrCopy, 0, 4);
		System.out.println(Arrays.toString(strArrCopy));
	}
}
