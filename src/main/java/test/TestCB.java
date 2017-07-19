package test;

import java.util.concurrent.CyclicBarrier;

public class TestCB {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(5, () -> {
			System.out.println("cb finish");
		});
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(1000);
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(String.format("耗时：%sms", System.currentTimeMillis() - start));
			}).start();
		}
	}
}
