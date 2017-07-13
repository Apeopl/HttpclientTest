package com.zjl.thread;

public class AcountingSync implements Runnable{
	static volatile int i = 0;
	@Override
	public void run() {
		for(int j=0; j<10000; j++){
			increase();
		}
	}

	private /*synchronized*/ void increase() {
		i++;
		System.out.println(Thread.currentThread().getName()+":"+i);
	}
	public static void main(String[] args) throws InterruptedException {
		AcountingSync as = new AcountingSync();
		Thread t1 = new Thread(as,"线程一");
		Thread t2 = new Thread(as,"线程二");
		Thread t3 = new Thread(as,"线程三");
		Thread t4 = new Thread(as,"线程四");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}
}
