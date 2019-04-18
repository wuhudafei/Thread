package com.wuhudafei;

import java.util.concurrent.CountDownLatch;

/**
 * countdownLatch �÷�
 * 
 * 
 * @author wuhudafei
 *	�ʼ����ԣ�����ɣ�������
 */
public class CountDowanLatchDemo {
	
	static int n = 6;
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(n);
		for ( int i= 1; i <= n; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"�뿪���ң��ؼ���Ů����");
				countDownLatch.countDown();//�Լ�1
			},County.getName(i)).start();
		}
		try {
			countDownLatch.await();//�ȴ�������Ҫ��countDownLatch��Ϊ0�Ż�����һ��ִ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("�ع����ţ��ؼҲ�");
		System.out.println(County.One);
		System.out.println(County.One.getCode());
		System.out.println(County.One.getName());
	}
	
}
