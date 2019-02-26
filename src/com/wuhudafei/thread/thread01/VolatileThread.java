package com.wuhudafei.thread.thread01;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileThread extends Thread{

	
	private volatile boolean isRunning = true;
	
	private void setRunning(boolean b){
		this.isRunning = b;
	}
	
	@Override
	public void run() {
		System.out.println("进入running方法");
		while(isRunning == true){
			//..
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		VolatileThread vt = new VolatileThread();
		vt.start();
		Thread.sleep(1000);
		vt.setRunning(false);
		System.out.println("已经被设置成false");
	}
	
	
	
	
	
	
	
	
	
//	private static AtomicInteger count = new AtomicInteger(0);
//	private void countAdd(){
//		for(int i=0;i<1000;i++){
//			count.incrementAndGet();
//		}
//		System.out.println(count);
//	}
//	
//	@Override
//	public void run() {
//		countAdd();
//	}
//	
//	public static void main(String[] args) {
//		
//		VolatileThread[] arr = new VolatileThread[10];
//		
//		for(int i=0;i<10;i++){
//			arr[i] = new VolatileThread();
//			arr[i].start();
//		}
//	}
	
}
