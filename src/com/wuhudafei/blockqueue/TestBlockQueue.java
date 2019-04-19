package com.wuhudafei.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ��������
 * add��remove����̫�Ե������쳣
 * 	add: java.lang.IllegalStateException: Queue full
 * 	remove: java.util.NoSuchElementException
 * 
 * offer��poll��������false��null �������쳣
 * 
 * put��take �������岻��ȥһֱ������ȡ������һֱ����
 * 
 * offer(e,time,unit)��poll(time,unit) ��2���Ӳ��롢ȡ��
 * 
 * @author wuhudafei
 *	�ʼ����ԣ�Ǯ��������ҽ������˼Ӱ����н
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
