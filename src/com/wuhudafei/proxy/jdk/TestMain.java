package com.wuhudafei.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Java动态代理
 * 目标类必须要实现一个接口
 * @author wuhudafei
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
		TargetImpl targetImpl = new TargetImpl();
		InvocationHandler proxyHandler = new ProxyHandler(targetImpl);
		
		TargetInterface proxyTargetImpl = (TargetInterface) Proxy.newProxyInstance(
				targetImpl.getClass().getClassLoader(), 
				targetImpl.getClass().getInterfaces(), 
				proxyHandler);
		System.out.println("targetImpl.getClass().getClassLoader():"+targetImpl.getClass().getClassLoader());
		System.out.println("targetImpl.getClass().getInterfaces():"+targetImpl.getClass().getInterfaces());
		Class<?>[] cl = targetImpl.getClass().getInterfaces();
		for (int i = 0; i < cl.length; i++) {
			Class<?> st = cl[i];
			System.out.println("99=="+st.getName());
		}

		System.out.println(proxyTargetImpl.whoIam("z"));
		System.out.println(proxyTargetImpl.whereTo());
		System.out.println(proxyTargetImpl.fromWhere());
		
	}
}
