package com.chenyj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/17 13:38
 * 陈银杰专属测试
 */
public class Thread09 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在执行");
                }
            });
        }
    }
}
