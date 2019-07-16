package com.chenyj.thread;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 8:50
 * 陈银杰专属测试
 *  setName();
 *  getName();
 *  sleep();
 *  join();
 *  yield()
 *
 *线程的优先级
 *  MAX_PRIORITY
 *  NORM_PRIORITY
 *  MIN_PRIORITY
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread01=new Thread02().new Thread0201("副线程01");
        Thread thread02=new Thread02().new Thread0201("副线程02");
        thread01.setPriority(Thread.MAX_PRIORITY);
        thread01.start();
//        thread01.join();
        thread02.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority()+i);
            if (i==5){
//                thread02.interrupt();
            }
        }
        System.out.println("主线程结束");
    }
    class Thread0201 extends Thread{
        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                }
            }
        }
        Thread0201(String name) {
            super(name);
        }
    }

}
