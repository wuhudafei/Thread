package com.wuhudafei.proxy.jdk;

public class TargetImpl implements TargetInterface {

	@Override
	public String whoIam(String s) {
		System.out.println("����˭��===>");
		return "wuhudafei";
	}

	@Override
	public String fromWhere() {
		System.out.println("���������===>");
		return "�����ߺ�";
	}

	@Override
	public String whereTo() {
		System.out.println("�ҽ�ȥ���η���===>");
		return "������ɽ";
	}

}
