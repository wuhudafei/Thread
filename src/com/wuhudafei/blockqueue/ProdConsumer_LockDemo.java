package com.wuhudafei.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者模式：ReentrantLock版本
 * 
 * @author wuhudafei
 *	笔记名言：写锁三部曲：判断，干活，通知
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
	
	//生产
	public void produce() throws InterruptedException{
		
		lock.lock();
		try {
			//1判断
			while(number != 0){
				condition.await();
			}
			//2干活
			number ++ ;
			System.out.println(Thread.currentThread().getName()+"生产第"+number+"辆汽车");
			
			//3通知
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	//消费
	public void consume() throws InterruptedException{
		lock.lock();
		try {
			//1判断
			while(number == 0){
				condition.await();
			}
			//2干活
			number -- ;
			System.out.println(Thread.currentThread().getName()+"消费第"+number+"辆汽车");
			
			//3通知
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
}
