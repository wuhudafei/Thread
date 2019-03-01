package com.wuhudafei.classJvm.jvm;

class StaticCode{
    int age;
    // static 代码块
    static{ System.out.print("static "); }
    //构造代码块
    { System.out.print("55 "); }    
    // 构造函数
    StaticCode(int age){
        this.age=age;
        System.out.print(age+",");
    }
    void show(){
    // 局部代码块
        {
            int age=30;
        }
        System.out.print("show:"+age+",");
    }
}
class StaticCodeDemo{
    public static void main(String[] args){
        StaticCode p1=new StaticCode(20);
        p1.show();
        StaticCode p2=new StaticCode(20);
    }
} 
