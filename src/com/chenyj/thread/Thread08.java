package com.chenyj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/17 13:15
 * 陈银杰专属测试
 */
public class Thread08 {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        Thread thread=new MyThrea();
        thread.setName("线程");
        service.execute(thread);

    }
}

class MyThrea extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            if (i%2==0){
                System.out.println(getName()+ i);
            }
        }
    }
}
