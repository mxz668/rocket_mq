package com.mxz.mq.thread;

/**
 * Created by MABIAO on 2017/3/20 0020.
 */
public class MyThread extends Thread {

    public void run(){
        for(int j = 0;j < 100;j++){
            System.out.println(Thread.currentThread().getName() + " " + j);
        }
    }
}
