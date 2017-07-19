package test;

import java.util.concurrent.CountDownLatch;

public class TestCDL {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(5);
		long start = System.currentTimeMillis();
		for(int i=0; i<10; i++){
			new Thread(){
				public void run(){
					try {
						Thread.sleep(500);
						System.out.println(String.format("耗时：%sms", System.currentTimeMillis()-start));
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						System.out.println(cdl.getCount());
						cdl.countDown();
					}
				}
			}.start();
		}
		cdl.await();
	}
}
