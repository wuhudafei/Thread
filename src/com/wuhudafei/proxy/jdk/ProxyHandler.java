package com.wuhudafei.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	private Object targetImpl;
	
	public ProxyHandler(Object targetImpl) {
		this.targetImpl = targetImpl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("proxy:"+proxy.getClass().getName());
		System.out.println("method:"+method.getName());//Ŀ�귽��
		System.out.println("args:"+args);//Ŀ�귽������ֵ�б�
//		for (int i = 0; i < args.length; i++) {
//			Object object = args[i];
//			System.out.println("JJ:"+object);
//		}
		
		System.out.println("Before invoke method..."); 
		Object object = method.invoke(targetImpl, args);
		System.out.println("After invoke method...");  
		
		return object;
	}

}
