package com.wuhudafei;

import java.util.concurrent.CountDownLatch;

/**
 * countdownLatch 用法
 * 
 * 
 * @author wuhudafei
 *	笔记名言：先完成，再完美
 */
public class CountDowanLatchDemo {
	
	static int n = 6;
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(n);
		for ( int i= 1; i <= n; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"离开教室，回家陪女朋友");
				countDownLatch.countDown();//自减1
			},County.getName(i)).start();
		}
		try {
			countDownLatch.await();//等待，，需要等countDownLatch减为0才会让下一步执行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("秦国锁门，回家草");
		System.out.println(County.One);
		System.out.println(County.One.getCode());
		System.out.println(County.One.getName());
	}
	
}
