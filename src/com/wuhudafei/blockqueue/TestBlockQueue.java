package com.wuhudafei.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * add、remove方法太霸道会抛异常
 * 	add: java.lang.IllegalStateException: Queue full
 * 	remove: java.util.NoSuchElementException
 * 
 * offer、poll方法返回false、null 不会抛异常
 * 
 * put、take 方法，插不进去一直阻塞、取不出来一直阻塞
 * 
 * offer(e,time,unit)、poll(time,unit) 过2秒钟插入、取出
 * 
 * @author wuhudafei
 *	笔记名言：钱多事少离家近，别人加班你加薪
 */
public class TestBlockQueue {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//		
//		System.out.println(blockingQueue.add("a"));
//		System.out.println(blockingQueue.add("b"));
//		System.out.println(blockingQueue.add("c"));
//		
//		System.out.println(blockingQueue.element());
//		
//		System.out.println(blockingQueue.remove());
//		System.out.println(blockingQueue.remove());
//		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("b",2L,TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("c",2L,TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("d",2L,TimeUnit.SECONDS));
		
//		System.out.println(blockingQueue.peek());
//		
//		System.out.println(blockingQueue.poll());
//		System.out.println(blockingQueue.poll());
//		System.out.println(blockingQueue.poll());
//		System.out.println(blockingQueue.poll());
	}
}
