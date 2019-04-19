package com.wuhudafei;

import java.util.concurrent.CyclicBarrier;

/**
 * 跟countDownLatch（递减） 用法相反
 * 所有线程都已经通过屏障，都已经到位，才会放行。
 * @author wuhudafei
 *
 */
public class CycliBarrierDemo {

	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(7, ()->{System.out.println("集齐7颗龙珠，开始放大招");});
		
		for (int i = 1; i <= 7; i++) {
			final int tempInt = i; 
			new Thread(()->{
				System.out.println(tempInt+"号龙珠已就位~");
				try {
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
