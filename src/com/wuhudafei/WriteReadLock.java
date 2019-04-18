package com.wuhudafei;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 共享读，独占原子写
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
			System.out.println(Thread.currentThread().getName()+"\t 正在写入..."+key);
			map.put(key, value);
			System.out.println(Thread.currentThread().getName()+"\t 写入完成...");
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	public void get(String key){
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 正在读取...");
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t 读取完成..."+result);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
}
