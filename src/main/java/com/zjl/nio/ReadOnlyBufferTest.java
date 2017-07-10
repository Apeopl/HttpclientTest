package com.zjl.nio;

import java.nio.ByteBuffer;

public class ReadOnlyBufferTest {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		for (int i = 0; i < byteBuffer.capacity(); i++) {
			byteBuffer.put((byte)i);
		}
		//创建只读缓冲区
		ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
		//改变原缓冲区的内容
		for(int i=0; i<byteBuffer.capacity(); i++){
			byte b = byteBuffer.get(i);
			b *= 10;
			byteBuffer.put(i, b);
		}
		readOnlyBuffer.flip();
		while(readOnlyBuffer.hasRemaining()){
			System.out.println(readOnlyBuffer.get());
		}
		/*for (int i = 0; i < readOnlyBuffer.capacity(); i++) {
			readOnlyBuffer.put((byte)i);
		}*/
	}
}
