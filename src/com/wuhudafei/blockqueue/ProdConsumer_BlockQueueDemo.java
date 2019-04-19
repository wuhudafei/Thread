package com.wuhudafei.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者-消费者模式：阻塞队列版本
 * 
 * @author wuhudafei
 *
 */
public class ProdConsumer_BlockQueueDemo {

	public static void main(String[] args) {
		Cake cake = new Cake(new ArrayBlockingQueue<>(10));
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 开始生产蛋糕...");
			cake.produce();
		},"produce").start();
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 开始消费蛋糕...");
			cake.consume();
		},"consume").start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cake.stop();
	}
}

class Cake{
	
	private volatile boolean Flag = true;
	private AtomicInteger atomicInteger = new AtomicInteger();
	private BlockingQueue<String> blockingQueue = null;
	
	public Cake(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
	}
	
	//生产
	public void produce(){
		
		boolean f = true;
		String cakeStr = null;
		while(Flag){
			try {
				cakeStr = "蛋糕"+atomicInteger.incrementAndGet()+"";
				f = blockingQueue.offer(cakeStr, 2L, TimeUnit.SECONDS);
				if(f){
					System.out.println(Thread.currentThread().getName()+"\t 生产"+cakeStr+"...成功");
				}else{
					System.out.println(Thread.currentThread().getName()+"\t 生产"+cakeStr+"...失败");
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("老板说不卖蛋糕了，我们不生产了");
	}
	
	//消费
	public void consume(){
		
		String result = null;
		while(Flag){
			try {
				result = blockingQueue.poll(2L, TimeUnit.SECONDS);
				if("" == result || null == result){
					Flag = false;
					System.out.println("超过2秒没有取到蛋糕，消费者退出");
					return ;
				}
				System.out.println(Thread.currentThread().getName()+"\t 开始取走"+result+"...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("老板说不卖蛋糕了，我们不买了");
	}
	
	//叫停
	public void stop(){
		this.Flag = false;
	}
}
