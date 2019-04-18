package com.wuhudafei;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 不用wait()，但是时间长对性能有损耗，注意使用场景
 * @author wuhudafei
 *
 *练武不练功，到老一场空
 */
public class SpinLockDemo {

	//default：null
	AtomicReference<Thread> atomicReference = new AtomicReference<>();
	
	void mylock(){
		Thread t = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t come in (*^▽^*)");
		while(!atomicReference.compareAndSet(null, t)){
			//第一个线程进入 atomicReference.compareAndSet(null, t) == true ,取反跳出循环
			//第二个线程进入等待。。。第一个线程unlock
		}
//		do {
//			System.out.println("do something...");
//		} while (!atomicReference.compareAndSet(null, t));
//		
	}
	
	void myUnlock(){
		Thread t = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t get out (*^▽^*)");
		atomicReference.compareAndSet(t, null);
	}
	
	public static void main(String[] args) {
		SpinLockDemo demo = new SpinLockDemo();
		new Thread(()->{
			demo.mylock();
			try {
				Thread.currentThread().sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			demo.myUnlock();
		},"t1").start();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Thread(()->{
			demo.mylock();
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			demo.myUnlock();
		},"t2").start();
//		int n = 0;
//		do {
//			n++;
//			System.out.println("ddddddddddddd"+n);
//		} while (n != 5);
		
	}
}
