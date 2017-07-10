package com.zjl.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) throws Exception{
		FileInputStream fin = new FileInputStream("D:\\ZZZ\\资料\\ORACLE软件配置.txt");
		FileChannel channel = fin.getChannel();
		//创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(2);
		//读取数据到缓冲区
		channel.read(buffer);
		buffer.flip();
		while(buffer.remaining()>0){
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			System.out.println(buffer.remaining());
			byte b = buffer.get();
			System.out.println("-----------------------------");
			//System.out.print((char)b);
		}
		fin.close();
	}
}
