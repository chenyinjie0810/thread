package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/14 21:53
 * 陈银杰专属测试
 */

class MyThread extends Thread{

    @Override
    public void run() {
        int a=100;
        for (int i=0;i<a;i++){
            try {
                Thread.sleep(100);
                if (i%3==0) {
                    System.out.println(Thread.currentThread().getName()+"   "+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"main+"+i);
        }
    }
}
