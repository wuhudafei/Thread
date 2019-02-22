package com.wuhudafei.thread.thread01;

public class SynchronizedThread {

	private synchronized void printA() throws InterruptedException{
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(3000);
		System.out.println("GG");
	}
	
	//synchronized 可变
	private synchronized void printB(){
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		/**
		 * synchronized 修饰的方法，代表的是对象锁，当一个线程获取了，另外的线程访问带有synchronized修饰的方法就得等待。
		 */
		final SynchronizedThread st = new SynchronizedThread();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					st.printA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				st.printB();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
	}
}
