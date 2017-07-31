package com.zjl.jdk8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年7月31日 下午1:50:55 
*/
public class ProcessTest {
	public static String processFile(BufferedReaderProcess p) throws IOException{
		try(BufferedReader br = new BufferedReader( new FileReader("D:\\sina.txt‪‪"))){
			return p.procee(br);//D:\\ZZZ\\资料\\资料\\技术点.
		}
	}
	public static void main(String[] args) throws Exception{
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		System.out.println(oneLine);
	}
}

