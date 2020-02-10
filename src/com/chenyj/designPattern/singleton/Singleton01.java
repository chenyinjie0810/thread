package com.chenyj.designPattern.singleton;

/**
 * @Author chenyj
 * @Description 饿汉式
 * @Date create by 2020/2/10 9:11
 * 陈银杰专属测试
 */
public class Singleton01{

    private static final Singleton01 singleton01=new Singleton01();

    public static Singleton01 getInstance(){
        return singleton01;
    }

    private Singleton01() {
    }
}

