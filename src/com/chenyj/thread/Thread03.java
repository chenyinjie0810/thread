package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 23:29
 * 陈银杰专属测试
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer a=new StringBuffer();
        StringBuffer b=new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    a.append("1");
                    b.append("a");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    a.append("2");
                    b.append("b");
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    a.append("3");
                    b.append("c");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    a.append("4");
                    b.append("d");
                }
            }
        }).start();
        Thread.sleep(100);
        System.out.println(a);
        System.out.println(b);
    }

}
