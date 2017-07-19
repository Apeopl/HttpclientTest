package test;

public class DeadLock {
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				synchronized (obj1) {
					System.out.println("thread1 get lock1!");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (obj2) {
						System.out.println("thread1 get lock2!");
					}
				}
				System.out.println("thread1 end.");
			}
		}.start();
		new Thread(){
			public void run(){
				synchronized (obj2) {
					System.out.println("thread1 get lock2!");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (obj1) {
						System.out.println("thread1 get lock1!");
					}
				}
				System.out.println("thread1 end.");
			}
		}.start();
	}
}
