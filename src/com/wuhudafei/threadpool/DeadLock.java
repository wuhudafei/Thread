package com.wuhudafei.threadpool;

public class DeadLock {

	public static void main(String[] args) {
		String lockA = "lockA";
		String lockB = "lockB";
		DeadLockDemo dld = new DeadLockDemo(lockA, lockB);
		DeadLockDemo dld2 = new DeadLockDemo(lockB, lockA);
		new Thread(dld,"Tread1").start();
		new Thread(dld2,"Tread2").start();
	}
}

class DeadLockDemo implements Runnable{
	
	private String lockA;
	private String lockB;
	public DeadLockDemo(String lockA, String lockB) {
		super();
		this.lockA = lockA;
		this.lockB = lockB;
	}
	@Override
	public void run() {
		synchronized (lockA) {
			System.out.println(Thread.currentThread().getName()+"≥÷”–À¯"+lockA);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockB) {
				System.out.println(Thread.currentThread().getName()+"≥¢ ‘”µ”–À¯"+lockB);
			}
		}
	}
}
