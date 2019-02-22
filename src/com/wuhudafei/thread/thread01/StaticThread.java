package com.wuhudafei.thread.thread01;

public class StaticThread {

	private static int count = 10;
	
	//static 可变
	//synchronized  可变
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
		 * 由static修饰的方法，其实属于类级别的方法，直接类名.方法调用，不用new对象，所以属于同一个对象
		 * 两个线程访问同一个对象的方法，方法上面加上synchronized关键字代表同步操作
		 * 需要等一个线程跑完才会释放锁给另一个线程
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
