package com.wuhudafei.thread.thread01;

public class MyThread extends Thread{

	private int count = 5;
	
	@Override
	public synchronized void run() {
		count -- ;
		System.out.println(Thread.currentThread().getName()+":"+count);
	}

	public static void main(String[] args) {
		
		/**
		 * 分析：当多个线程访问myThread的run方法时，以排队的方式进行处理（这里排队是按照CPU分配的先后顺序来定的）
		 * 一个线程想要执行synchronized这个修饰的方法里面的代码
		 * 		1尝试获得锁
		 * 		2如果拿到锁，执行synchronized代码体内容；拿不到锁，这个线程会不停的尝试去获得这把锁，直到拿到为止
		 * 		而且是多个线程同时竞争这把锁（这里存在锁竞争问题）
		 */
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
