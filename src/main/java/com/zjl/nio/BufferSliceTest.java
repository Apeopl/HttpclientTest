package com.zjl.nio;

import java.nio.ByteBuffer;

public class BufferSliceTest {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		//存入数据
		for(int i=0; i<byteBuffer.capacity(); i++){
			byteBuffer.put((byte)i);
		}
		//创建子缓冲区
		byteBuffer.position(3);
		byteBuffer.limit(7);
		ByteBuffer subBuffer = byteBuffer.slice();
		//改变子缓冲区的内容
		for(int i=0; i<subBuffer.capacity(); i++){
			byte b = subBuffer.get(i);
			b *= 10;
			subBuffer.put(i, b);
		}
		byteBuffer.position(0);
		byteBuffer.limit(byteBuffer.capacity());
		while(byteBuffer.hasRemaining()){
			System.out.println(byteBuffer.get());
		}
	}
}
