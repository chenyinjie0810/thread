package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 20:13
 * 陈银杰专属测试
 */
public class ThreadRunable {
    public static void main(String[] args) throws InterruptedException {
        Runnable myThread01=new MyThread01();
        Thread thread01=new Thread(myThread01);
        Thread thread02=new Thread(myThread01);
        Thread thread03=new Thread(myThread01);
        thread01.setName("一号窗口");
        thread02.setName("二号窗口");
        thread03.setName("三号窗口");
        thread02.start();
        thread01.start();
        thread03.start();
    }
}

class MyThread01 implements Runnable{
    private int ticket=30;

    private Object object=new Object();
    @Override
    public void run() {
        synchronized (object){
            while (true){
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( Thread.currentThread().getName()+"卖出了"+ticket+"票");
                    ticket--;
                }
                else {
                    break;
                }
            }
        }
    }
}

