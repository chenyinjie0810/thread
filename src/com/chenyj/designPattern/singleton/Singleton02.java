package com.chenyj.designPattern.singleton;

import java.util.concurrent.*;

/**
 * @Author chenyj
 * @Description 懒汉式-线程不安全
 * @Date create by 2020/2/10 16:45
 * 陈银杰专属测试
 */
public class Singleton02 {
    private static Singleton02 singleton02=null;
    public static Singleton02 getInstance() {
        if (singleton02==null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton02=new Singleton02();
        }
        return singleton02;
    }
    private Singleton02(){
    }
}

class  A{
    public static void main(String[] args) {
        Callable<Singleton02> singleton02Callable=new Callable<Singleton02>() {
            @Override
            public Singleton02 call() throws Exception {
                return  Singleton02.getInstance();
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Singleton02> submit1 = executorService.submit(singleton02Callable);
        Future<Singleton02> submit2 = executorService.submit(singleton02Callable);
        Singleton02 singleton021 = null;
        Singleton02 singleton022 = null;
        try {
            singleton021 = submit1.get();
            singleton022 = submit2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(singleton021==singleton022);
    }
}