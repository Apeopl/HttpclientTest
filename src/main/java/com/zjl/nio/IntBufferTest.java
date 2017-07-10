package com.zjl.nio;

import java.nio.IntBuffer;

public class IntBufferTest {
	public static void main(String[] args) {
		//分配新的int缓冲区，参数为缓冲区容量
		IntBuffer intBuffer = IntBuffer.allocate(2);
		for (int i = 0; i < intBuffer.capacity(); i++) {
			int j = 2 * (i+1);
			//将给定的整数写入此缓冲区的当前位置，当前位置递增
			intBuffer.put(j);
		}
		intBuffer.flip();
		while(intBuffer.hasRemaining()){
			int j = intBuffer.get();
			System.out.println(j+" ");
		}
	}
}
