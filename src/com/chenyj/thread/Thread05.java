package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/16 21:56
 * 陈银杰专属测试
 */
public class Thread05 {
    public static void main(String[] args) {
        Runnable number=new Number();
        Thread thread1=new Thread(number);
        Thread thread2=new Thread(number);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread1.start();
        thread2.start();
    }
}
class Number implements Runnable{
    private int number=0;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (number<100){
                    System.out.println(Thread.currentThread().getName()+" "+number);
                    number++;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
