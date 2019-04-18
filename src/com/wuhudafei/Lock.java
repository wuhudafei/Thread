package com.wuhudafei;

/**
 * 重入锁
 * 线程访问资源类
 * @author wuhudafei
 *
 */
public class Lock {

	public static void main(String[] args) {
		Phone phone = new Phone();
		new Thread(new Runnable() {
			@Override
			public void run() {
				phone.get();
			}
		},"t1").start();
		
		new Thread(()->{//JDK1.8的写法
			phone.get();
		},"t2").start();
		
	}
	
}

class Phone{
	
	synchronized void get(){
		System.out.println(Thread.currentThread().getName()+"\t invokedGet()");
		set();
	}
	
	synchronized void set(){
		System.out.println(Thread.currentThread().getName()+"\t ####invokedSet()");
		
	}
}
