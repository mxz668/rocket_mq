package com.mxz.mq.thread;

/**
 * Created by MABIAO on 2017/3/20 0020.
 */
public class ThreadTest {

    public static void main(String args[]){
        int t = 6/0;
        try {
            for (int i = 0; i < 100000000; i++){
                MyThread thread = new MyThread();
                thread.start();
            }
            MyThread thread1 = new MyThread();
            MyThread thread2 = new MyThread();
            thread2.setPriority(10);
            thread1.setPriority(10);
            Thread.sleep(36000L);
            thread1.start();
            thread2.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
