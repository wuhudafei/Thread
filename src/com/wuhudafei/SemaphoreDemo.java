package com.wuhudafei;

import java.util.concurrent.Semaphore;

/**
 * 区别于 countDownLatch,CyclicBarrier
 * Semaphore是有增有减的
 * @author wuhudafei
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);//三个车位
		
		for (int i = 1; i <= 6; i++) {//6个车
			new Thread(()->{
				try {
					semaphore.acquire();//抢占车位
					System.out.println(Thread.currentThread().getName()+"抢占了车位");
					Thread.currentThread().sleep(3000);
					System.out.println(Thread.currentThread().getName()+"离开了车位");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					semaphore.release();//释放车位
				}
			},String.valueOf(i)).start();
		}
	}
}
