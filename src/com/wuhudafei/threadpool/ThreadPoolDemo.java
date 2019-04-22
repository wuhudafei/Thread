package com.wuhudafei.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的用法
 * 7个参数配置
 * 
 * 最大线程数 算法：
 * CPU密集：CPU核数+1
 * IO密集：1、IO 大，线程数要求多 CPU核数*2；  2、IO大，任务队列要求高 CPU核数/（1-0.8或0.9）
 * 
 * @author wuhudafei
 *
 */
public class ThreadPoolDemo {

	public static void main(String[] args) {
		
		//查看电脑的CPU核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
				5, //corePoolSize 
				8, //maximumPoolSize 
				0L, //keepAliveTime 
				TimeUnit.SECONDS, //unit 
				new ArrayBlockingQueue<Runnable>(3), 
				Executors.defaultThreadFactory(), 
				new ThreadPoolExecutor.AbortPolicy());
		try {
			for (int i = 1; i <= 12; i++) {
				//11个刚好，12个超标抛出异常
				threadPoolExecutor.execute(()->{
					System.out.println(Thread.currentThread().getName()+"处理业务");
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			threadPoolExecutor.shutdown();
		}
	}
}
