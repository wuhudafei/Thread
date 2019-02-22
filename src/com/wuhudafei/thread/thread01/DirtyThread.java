package com.wuhudafei.thread.thread01;

/**
 * ���
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
	
	//synchronized �ɱ�
	private void getValue(){
		System.out.println(this.name+" love play "+this.hobby);
	}
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Oracle���ݿ�� ACID����������������⣬�ڲ��и�undo���Լ�¼��ǰ״̬��snapshot��
		 * A--Atomicity--ԭ����
		 * C--Consistency--һ����
		 * I--Isolation--������
		 * D--Durability--�־���
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
