package com.chenyj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/1/4 11:22
 * 陈银杰专属测试
 */
public class Test03 {
    public static void main(String[] args) {
        checkPrimeNumber(1,10000);
    }

    public static void checkPrimeNumber(int begin,int end){
        int a=end/1000;
        ExecutorService executorService= Executors.newFixedThreadPool(a);
        if(a>0){
            for (int i = 0; i < a; i++) {
                int start=begin;
                if (i==a-1){
                    begin=end;
                }else {
                    begin=begin+999;
                }
                Num num=new Num(start,begin);
                Check check=new Check(num);
                executorService.execute(check);
                begin++;
            }
        }
    }
}
