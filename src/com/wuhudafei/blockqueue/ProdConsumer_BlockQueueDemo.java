package com.wuhudafei.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������-������ģʽ���������а汾
 * 
 * @author wuhudafei
 *
 */
public class ProdConsumer_BlockQueueDemo {

	public static void main(String[] args) {
		Cake cake = new Cake(new ArrayBlockingQueue<>(10));
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t ��ʼ��������...");
			cake.produce();
		},"produce").start();
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t ��ʼ���ѵ���...");
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
	
	//����
	public void produce(){
		
		boolean f = true;
		String cakeStr = null;
		while(Flag){
			try {
				cakeStr = "����"+atomicInteger.incrementAndGet()+"";
				f = blockingQueue.offer(cakeStr, 2L, TimeUnit.SECONDS);
				if(f){
					System.out.println(Thread.currentThread().getName()+"\t ����"+cakeStr+"...�ɹ�");
				}else{
					System.out.println(Thread.currentThread().getName()+"\t ����"+cakeStr+"...ʧ��");
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ϰ�˵���������ˣ����ǲ�������");
	}
	
	//����
	public void consume(){
		
		String result = null;
		while(Flag){
			try {
				result = blockingQueue.poll(2L, TimeUnit.SECONDS);
				if("" == result || null == result){
					Flag = false;
					System.out.println("����2��û��ȡ�����⣬�������˳�");
					return ;
				}
				System.out.println(Thread.currentThread().getName()+"\t ��ʼȡ��"+result+"...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ϰ�˵���������ˣ����ǲ�����");
	}
	
	//��ͣ
	public void stop(){
		this.Flag = false;
	}
}
