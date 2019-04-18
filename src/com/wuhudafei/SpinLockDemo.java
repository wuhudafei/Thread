package com.wuhudafei;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ������
 * ����wait()������ʱ�䳤����������ģ�ע��ʹ�ó���
 * @author wuhudafei
 *
 *���䲻����������һ����
 */
public class SpinLockDemo {

	//default��null
	AtomicReference<Thread> atomicReference = new AtomicReference<>();
	
	void mylock(){
		Thread t = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t come in (*^��^*)");
		while(!atomicReference.compareAndSet(null, t)){
			//��һ���߳̽��� atomicReference.compareAndSet(null, t) == true ,ȡ������ѭ��
			//�ڶ����߳̽���ȴ���������һ���߳�unlock
		}
//		do {
//			System.out.println("do something...");
//		} while (!atomicReference.compareAndSet(null, t));
//		
	}
	
	void myUnlock(){
		Thread t = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t get out (*^��^*)");
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
