package com.wuhudafei;

import java.util.concurrent.CyclicBarrier;

/**
 * ��countDownLatch���ݼ��� �÷��෴
 * �����̶߳��Ѿ�ͨ�����ϣ����Ѿ���λ���Ż���С�
 * @author wuhudafei
 *
 */
public class CycliBarrierDemo {

	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(7, ()->{System.out.println("����7�����飬��ʼ�Ŵ���");});
		
		for (int i = 1; i <= 7; i++) {
			final int tempInt = i; 
			new Thread(()->{
				System.out.println(tempInt+"�������Ѿ�λ~");
				try {
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
