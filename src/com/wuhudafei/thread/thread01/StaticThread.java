package com.wuhudafei.thread.thread01;

public class StaticThread {

	private static int count = 10;
	
	//static �ɱ�
	//synchronized  �ɱ�
	private static synchronized void getNum(String arg) throws Exception{
		
		if("a".equals(arg)){
			count = 100;
			System.out.println("set a = "+count);
			Thread.sleep(1000);
			System.out.println("set a success");
		}else{
			count = 0;
			System.out.println("set b = "+count);
			System.out.println("set b success");
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 * ��static���εķ�������ʵ�����༶��ķ�����ֱ������.�������ã�����new������������ͬһ������
		 * �����̷߳���ͬһ������ķ����������������synchronized�ؼ��ִ���ͬ������
		 * ��Ҫ��һ���߳�����Ż��ͷ�������һ���߳�
		 */
		
		final StaticThread st1 = new StaticThread();
		final StaticThread st2 = new StaticThread();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					st1.getNum("a");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					st2.getNum("b");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
