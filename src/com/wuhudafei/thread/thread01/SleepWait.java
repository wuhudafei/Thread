package com.wuhudafei.thread.thread01;

/**
 * java�е�sleep()��wait()������
 */
public class SleepWait {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }
    
    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (SleepWait.class) {
            System.out.println("enter thread1...");    
            System.out.println("thread1 is waiting...");
            try {
                //����wait()�������̻߳����������������ȴ��˶���ĵȴ�������
            	SleepWait.class.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is going on ....");
            System.out.println("thread1 is over!!!");
            }
        }
    }
    
    private static class Thread2 implements Runnable{
        @Override
        public void run(){
            synchronized (SleepWait.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //ֻ����Դ˶������notify()�������̲߳Ž������������׼����ȡ��������������״̬��
                SleepWait.class.notify();
                //==================
                //����
                //������ǰѴ��룺SleepWait.class.notify();��ע�͵�����SleepWait.class������wait()����������û�е���notify()
                //���������߳���Զ���ڹ���״̬��
                try {
                    //sleep()���������˳�����ִͣ��ָ����ʱ�䣬�ó�cpu�������̣߳�
                    //�������ļ��״̬��Ȼ�����ߣ���ָ����ʱ�䵽���ֻ��Զ��ָ�����״̬��
                    //�ڵ���sleep()�����Ĺ����У��̲߳����ͷŶ�������
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}