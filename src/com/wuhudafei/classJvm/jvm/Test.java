package com.wuhudafei.classJvm.jvm;

	public class Test
	{
	    static
	    {
	        i=0;
	        System.out.println(1);//这句编译器会报错：Cannot reference a field before it is defined（非法向前应用）
	    }
	    static int i=1;
}
