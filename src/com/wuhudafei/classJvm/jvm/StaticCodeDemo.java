package com.wuhudafei.classJvm.jvm;

class StaticCode{
    int age;
    // static �����
    static{ System.out.print("static "); }
    //��������
    { System.out.print("55 "); }    
    // ���캯��
    StaticCode(int age){
        this.age=age;
        System.out.print(age+",");
    }
    void show(){
    // �ֲ������
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
