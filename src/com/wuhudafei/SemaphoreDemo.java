package com.wuhudafei;

import java.util.concurrent.Semaphore;

/**
 * ������ countDownLatch,CyclicBarrier
 * Semaphore�������м���
 * @author wuhudafei
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);//������λ
		
		for (int i = 1; i <= 6; i++) {//6����
			new Thread(()->{
				try {
					semaphore.acquire();//��ռ��λ
					System.out.println(Thread.currentThread().getName()+"��ռ�˳�λ");
					Thread.currentThread().sleep(3000);
					System.out.println(Thread.currentThread().getName()+"�뿪�˳�λ");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					semaphore.release();//�ͷų�λ
				}
			},String.valueOf(i)).start();
		}
	}
}
