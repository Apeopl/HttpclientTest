package com.zjl.iostream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutWriteTest {
	public static void main(String[] args) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("C:/Users/king-zheng/Desktop/out.txt",true));
			out.write("你好！世界");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
