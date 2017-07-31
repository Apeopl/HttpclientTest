package com.zjl.jdk8;

import java.io.BufferedReader;
import java.io.IOException;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年7月31日 下午1:49:02 
*/
@FunctionalInterface
public interface BufferedReaderProcess {
	String procee(BufferedReader br) throws IOException;
}

