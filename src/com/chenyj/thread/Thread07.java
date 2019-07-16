package com.chenyj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/16 23:06
 * 陈银杰专属测试
 */

class CallTest implements Callable{

    @Override
    public Object call() throws Exception {
        int value=0;
        for (int i = 0; i < 100; i++) {
            if (100%2==0){
                value+=i;
                System.out.println(value);
            }
        }
        return value;
    }
}


public class Thread07 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallTest callTest=new CallTest();
        FutureTask futureTask=new FutureTask(callTest);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println("总价"+futureTask.get());
    }
}