package com.wuhudafei.thread.thread01;

/**
 * 脏读
 */
public class DirtyThread {
	
	private String name = "zhang3";
	private String hobby = "basketball";
	
	private synchronized void setValue(String name, String hobby) throws InterruptedException{
		
		this.name = name;
		Thread.sleep(3000);
		this.hobby = hobby;
		System.out.println(this.name+" love play "+this.hobby);
	}
	
	//synchronized 可变
	private void getValue(){
		System.out.println(this.name+" love play "+this.hobby);
	}
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Oracle数据库的 ACID，避免了脏读的问题，内部有个undo可以记录当前状态的snapshot。
		 * A--Atomicity--原子性
		 * C--Consistency--一致性
		 * I--Isolation--隔离性
		 * D--Durability--持久性
		 */
		final DirtyThread dt = new DirtyThread();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					dt.setValue("li4", "football");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Thread.sleep(1000);
		dt.getValue();
	}
}
