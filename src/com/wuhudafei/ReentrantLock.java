package com.wuhudafei;


/**
 * 重入锁
 * 线程访问资源类
 * @author wuhudafei
 *	理论-代码-小总结：三板斧
 *	
 */
public class ReentrantLock {

	public static void main(String[] args) {
		PhoneX phone = new PhoneX();
		
		Thread t1 = new Thread(phone,"t1");
		Thread t2 = new Thread(phone,"t2");
		
		t1.start();
		t2.start();
	}
	
}

class PhoneX implements Runnable{
	
	java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
	
	void get(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t invokedGet()");
			set();
		} finally {
			lock.unlock();
		}
	}
	
	void set(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t ####invokedSet()");
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		
		get();
		
	}
}
