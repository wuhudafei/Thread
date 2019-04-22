package com.wuhudafei.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳ص��÷�
 * 7����������
 * 
 * ����߳��� �㷨��
 * CPU�ܼ���CPU����+1
 * IO�ܼ���1��IO ���߳���Ҫ��� CPU����*2��  2��IO���������Ҫ��� CPU����/��1-0.8��0.9��
 * 
 * @author wuhudafei
 *
 */
public class ThreadPoolDemo {

	public static void main(String[] args) {
		
		//�鿴���Ե�CPU����
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
				//11���պã�12�������׳��쳣
				threadPoolExecutor.execute(()->{
					System.out.println(Thread.currentThread().getName()+"����ҵ��");
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			threadPoolExecutor.shutdown();
		}
	}
}
