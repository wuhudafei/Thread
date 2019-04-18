package com.wuhudafei;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д��
 * ���������ռԭ��д
 * @author wuhudafei
 *
 */
public class WriteReadLock {

	public static void main(String[] args) {
		WriteReadMap wr = new WriteReadMap();
		for (int i = 1; i <= 5; i++) {
			final int tem = i;
			new Thread(()->{
				wr.put(tem+"", tem+"");
			},String.valueOf(i)).start();
		}
		
		for (int i = 1; i <= 5; i++) {
			final int tem = i;
			new Thread(()->{
				wr.get(tem+"");
			},String.valueOf(i)).start();
		}
	}
}

class WriteReadMap{
	
	volatile Map<String,Object> map = new HashMap<>();
	
	ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void put(String key, Object value){
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t ����д��..."+key);
			map.put(key, value);
			System.out.println(Thread.currentThread().getName()+"\t д�����...");
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	public void get(String key){
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t ���ڶ�ȡ...");
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t ��ȡ���..."+result);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
}
