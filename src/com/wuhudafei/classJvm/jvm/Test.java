package com.wuhudafei.classJvm.jvm;

	public class Test
	{
	    static
	    {
	        i=0;
	        System.out.println(1);//���������ᱨ��Cannot reference a field before it is defined���Ƿ���ǰӦ�ã�
	    }
	    static int i=1;
}
