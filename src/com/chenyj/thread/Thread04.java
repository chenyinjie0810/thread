package com.chenyj.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/16 21:33
 * 陈银杰专属测试
 */
public class Thread04 {

    public static void main(String[] args) {
        Runnable user=new user();
        Thread thread01=new Thread(user);
        Thread thread02=new Thread(user);
        thread01.setName("张三");
        thread02.setName("李四");
        thread01.start();
        thread02.start();
    }

}

class user implements Runnable{

    private static float balance;

    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
      /* lock.lock();*/
        for (int i = 0; i < 3 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance+=1000;
            System.out.println(Thread.currentThread().getName()+"存入了"+1000+",余额是"+balance);
        }
       /* lock.unlock();*/
    }
}
