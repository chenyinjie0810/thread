package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/1/4 10:27
 * 陈银杰专属测试
 */
public class Test01 {
    public static void main(String[] args) {
        checkPrimeNumber(1,1000);
    }

    /**
     * @desc: 查找范围内质数
     * @author: chenyj
     * @date: 2020/1/4
     * @param begin
     * @param end
     */
    public static void checkPrimeNumber(int begin,int end){
        for(int i=begin;i<=end;i++){
            boolean flag=true;
            if (i==1){
                flag=false;
                continue;
            }
            for (int j = 2; j <i ; j++) {
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }


}
