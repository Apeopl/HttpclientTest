package com.zjl.socket;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	public static void main(String[] args) throws Exception{
		int port = 8899;
		ServerSocket server = new ServerSocket(port);
		while(true){
			Socket socket = server.accept();
			new Thread(new Task(socket)).start();
		}
	}
	static class Task implements Runnable{
		private Socket socket;
		public Task(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				handleSocket();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		private void handleSocket() throws Exception{
			Reader reader = new InputStreamReader(socket.getInputStream(),"UTF-8");
			char[] chs = new char[64];
			int len;
			String temp;
			int index;
			StringBuilder sb = new StringBuilder();
			while((len=reader.read(chs))!=-1){
				temp = new String(chs, 0, len);
				if((index = temp.indexOf("eof"))!=-1){
					sb.append(temp.substring(0, index));
					break;
				}
				sb.append(temp);
			}
			System.out.println("from client:"+sb);
			//读完写一句
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write("Hello Client!");
			writer.write("eof");
			writer.flush();
			writer.close();
			reader.close();
			socket.close();
		}
		
	}
}
