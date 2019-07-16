package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/16 22:37
 * 陈银杰专属测试
 */
public class Thread06 {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer producer=new Producer(clerk);
        Consumer consumer=new Consumer(clerk);
        producer.setName("生产者");
        consumer.setName("消费者");
        producer.start();
        consumer.start();
    }
}

class Clerk {
    private int numbers=0;

   synchronized void ProducerTest() {
       if (numbers<20){
           notify();
           numbers++;
           System.out.println(Thread.currentThread().getName()+"生产第"+numbers+"产品");
       }else {
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    synchronized void Consumer() {
        if (numbers>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+numbers+"产品");
            numbers--;
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.ProducerTest();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
       while (true){
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           clerk.Consumer();
       }
    }
}