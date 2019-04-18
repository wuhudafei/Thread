package com.wuhudafei;

public enum County {

	One(1,"齐国"),two(2,"楚国"),three(3,"赵国"),four(4,"燕国"),five(5,"韩国"),six(6,"魏国");
	
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
