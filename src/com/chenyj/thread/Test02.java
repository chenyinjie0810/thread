package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/1/4 10:44
 * 陈银杰专属测试
 */
public class Test02 {
    public static void main(String[] args) {
//        Num num=new Num(1,10000);
//        Check check=new Check(num);
//        check.start();
        checkPrimeNumber(1,10000);
    }

    public static void checkPrimeNumber(int begin,int end){
        int a=end/1000;
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
                check.start();
                begin++;
            }
        }
    }

}
class Num{
    private int begin;
    private int end;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Num(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}

class Check extends Thread{
    private Num num;

    public Check(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        int begin=num.getBegin();
        int end=num.getEnd();
        Test01.checkPrimeNumber(begin, end);
    }
}
