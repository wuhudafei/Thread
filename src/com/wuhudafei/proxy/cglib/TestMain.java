package com.wuhudafei.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * cglibʵ�ֶ�̬����
 * 
 * @author wuhudafei
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
	    Enhancer enhancer=new Enhancer();  
	    enhancer.setSuperclass(ConcreteClassNoInterface.class);  
	    enhancer.setCallback(new ConcreteClassInterceptor());  
	    ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();  

	    ccni.getConcreteMethodA("shensy");  
	    ccni.getConcreteMethodB(0);  

	}
}
