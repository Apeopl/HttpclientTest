package test;

import java.io.IOException;

public class DaemonTest {
	public static void execute(){
		for(int i=0; ; i++){
			try {
				Thread.sleep(500);
				System.out.println("正在执行...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Thread thread = new Thread(() -> execute());
		thread.setDaemon(true);
		thread.start();
		System.in.read();
	}
}
