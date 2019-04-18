package com.wuhudafei;

public enum County {

	One(1,"���"),two(2,"����"),three(3,"�Թ�"),four(4,"���"),five(5,"����"),six(6,"κ��");
	
	private County(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	private Integer code;
	private String name;
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	static String getName(int index){
		County[] cArr = County.values();
		for (County county : cArr) {
			if(county.getCode() == index){
				return county.getName();
			}
		}
		return null;
	}
	
}
