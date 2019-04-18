package com.wuhudafei;

import java.util.concurrent.atomic.*;

public class TestVolatile {

	volatile static AtomicInteger a = new AtomicInteger();
	
	static void add(){
		 for (int i = 0; i < 100; i++) {
			a.getAndIncrement();
		}
	}
	 
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					add();
					System.out.println(Thread.currentThread().getName()+"\t"+a);
				}
			},"t"+i).start();
		}
	}
}
