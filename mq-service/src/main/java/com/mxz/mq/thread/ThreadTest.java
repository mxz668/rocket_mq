package com.mxz.mq.thread;

/**
 * Created by MABIAO on 2017/3/20 0020.
 */
public class ThreadTest {

    public static void main(String args[]){
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread2.setPriority(10);
        thread1.setPriority(10);
        thread1.start();
        thread2.start();
    }
}
