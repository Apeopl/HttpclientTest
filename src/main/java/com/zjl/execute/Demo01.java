package com.zjl.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo01 {
	private static int pages = 1;
	private static boolean flag = true;
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		while(flag){
			if(pages<=100){
				service.execute(new Runnable() {
					
					@Override
					public void run() {
						System.err.println("爬取了第"+pages+"个网页");
						pages++;
					}
				});
			}else{
				if(((ThreadPoolExecutor)service).getActiveCount()==0){
					service.shutdown();
					flag = false;
					System.err.println("任务已经结束！");
				}
			}
			System.out.println(((ThreadPoolExecutor)service).getActiveCount());
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
