package com.wuhudafei;

public class WhileClass {

	
	public static void main(String[] args) {
		
		while(true){
			try {
				//½µµÍCPU
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
