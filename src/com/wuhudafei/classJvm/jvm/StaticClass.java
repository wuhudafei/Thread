package com.wuhudafei.classJvm.jvm;
public class StaticClass
{
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticClass st = new StaticClass();
 
    static
    {
    	System.out.println("1");
    }
    {
        System.out.println("2");
    }
    
    StaticClass()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
 
    public static void staticFunction(){
        System.out.println("4");
    }
 
    int a=110;
    static int b =112;
    
}
