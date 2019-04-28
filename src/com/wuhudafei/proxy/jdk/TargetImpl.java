package com.wuhudafei.proxy.jdk;

public class TargetImpl implements TargetInterface {

	@Override
	public String whoIam(String s) {
		System.out.println("我是谁？===>");
		return "wuhudafei";
	}

	@Override
	public String fromWhere() {
		System.out.println("我来自哪里？===>");
		return "安徽芜湖";
	}

	@Override
	public String whereTo() {
		System.out.println("我将去往何方？===>");
		return "杭州萧山";
	}

}
