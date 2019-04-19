package com.wuhudafei.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������-������ģʽ��ReentrantLock�汾
 * 
 * @author wuhudafei
 *	�ʼ����ԣ�д�����������жϣ��ɻ֪ͨ
 */
public class ProdConsumer_LockDemo {

	public static void main(String[] args) throws InterruptedException {
	
		Car car = new Car();
		
		new Thread(()->{
			try {
				for (int i = 1; i < 5; i++) {
					car.produce();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"produce").start();
		
		new Thread(()->{
			try {
				for (int i = 1; i < 5; i++) {
					car.consume();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"consume").start();
		
	}
}

class Car{
	
	private volatile int number = 0;
	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	//����
	public void produce() throws InterruptedException{
		
		lock.lock();
		try {
			//1�ж�
			while(number != 0){
				condition.await();
			}
			//2�ɻ�
			number ++ ;
			System.out.println(Thread.currentThread().getName()+"������"+number+"������");
			
			//3֪ͨ
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	//����
	public void consume() throws InterruptedException{
		lock.lock();
		try {
			//1�ж�
			while(number == 0){
				condition.await();
			}
			//2�ɻ�
			number -- ;
			System.out.println(Thread.currentThread().getName()+"���ѵ�"+number+"������");
			
			//3֪ͨ
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
}
