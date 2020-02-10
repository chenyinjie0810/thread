package com.chenyj.designPattern.singleton;

import java.util.concurrent.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/2/10 17:34
 * 陈银杰专属测试
 */
public class Singleton04 {
    private static class Build{
        public static final Singleton04 singleton04=new Singleton04();
    }
    public static final Singleton04 getInstance(){
        return Build.singleton04;
    }
    private Singleton04(){

    }
}

class C{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable=new Callable() {
            @Override
            public Object call() throws Exception {
                return Singleton04.getInstance();
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future submit01 = executorService.submit(callable);
        Future submit02 = executorService.submit(callable);
        Singleton04 singleton0301 = (Singleton04) submit01.get();
        Singleton04 singleton0302 = (Singleton04) submit02.get();
        System.out.println(singleton0301==singleton0302);
    }
}
