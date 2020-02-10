package com.chenyj.designPattern.singleton;

import java.util.concurrent.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/2/10 17:23
 * 陈银杰专属测试
 */
public class Singleton03 {
    private volatile static Singleton03 singleton03=null;
    public static Singleton03 getInstance() {
        if (singleton03==null){
            synchronized (Singleton03.class){
                if (singleton03==null){
                    singleton03=new Singleton03();
                }
            }
        }
        return singleton03;
    }
    private Singleton03(){
    }
}
class B{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable=new Callable() {
            @Override
            public Object call() throws Exception {
                return Singleton03.getInstance();
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future submit01 = executorService.submit(callable);
        Future submit02 = executorService.submit(callable);
        Singleton03 singleton0301 = (Singleton03) submit01.get();
        Singleton03 singleton0302 = (Singleton03) submit02.get();
        System.out.println(singleton0301==singleton0302);
    }
}
