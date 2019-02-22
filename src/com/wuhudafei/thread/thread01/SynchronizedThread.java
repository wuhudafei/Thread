package com.wuhudafei.thread.thread01;

public class SynchronizedThread {

	private synchronized void printA() throws InterruptedException{
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(3000);
		System.out.println("GG");
	}
	
	//synchronized �ɱ�
	private synchronized void printB(){
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		/**
		 * synchronized ���εķ�����������Ƕ���������һ���̻߳�ȡ�ˣ�������̷߳��ʴ���synchronized���εķ����͵õȴ���
		 */
		final SynchronizedThread st = new SynchronizedThread();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					st.printA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				st.printB();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
	}
}
