package com.zjl.socket;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ClientSocketTest2 {
	public static void main(String[] args) throws Exception{
		String host = "127.0.0.1";
		int port = 8899;
		Socket socket = new Socket(host, port);
		OutputStream outputStream = socket.getOutputStream();
		Writer writer = new OutputStreamWriter(outputStream,"gbk");
		writer.write("你好，服务器2!");
		writer.write("eof");
		writer.flush();
		Reader reader = new InputStreamReader(socket.getInputStream());
		StringBuilder sb = new StringBuilder();
		char[] chs = new char[64];
		String temp;
		int len;
		int index;
		while((len=reader.read(chs))!=-1){
			temp = new String(chs, 0, len);
			if((index=temp.indexOf("eof"))!=-1){
				sb.append(temp.substring(0, index));
				break;
			}
			sb.append(temp);
		}
		System.out.println("from server:"+sb);
		writer.close();
		reader.close();
		socket.close();
	}
}
