package com.wuhudafei.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 类似与生产者消费者模式，不过阻塞队列里面就一个元素。
 * @author wuhudafei
 *
 */
public class TestSyncBlockQueue {

	public static void main(String[] args) {
		
		BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//默认false
		
		new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+"\t put 1");
				blockingQueue.put("1");
				
				System.out.println(Thread.currentThread().getName()+"\t put 2");
				blockingQueue.put("2");
				
				System.out.println(Thread.currentThread().getName()+"\t put 3");
				blockingQueue.put("3");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		},"AAA").start();
		
		new Thread(()->{
			try {
				
//				Thread.currentThread().sleep(2000);
				System.out.println(Thread.currentThread().getName()+"\t take "+blockingQueue.take());
//				Thread.currentThread().sleep(2000);
				System.out.println(Thread.currentThread().getName()+"\t take "+blockingQueue.take());
//				Thread.currentThread().sleep(2000);
				System.out.println(Thread.currentThread().getName()+"\t take "+blockingQueue.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		},"BBB").start();
	}
}
