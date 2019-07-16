package com.chenyj.designPattern.factory;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:25
 * 陈银杰专属测试
 */
public class Test {
    public static void main(String[] args) {
        Car car=new CarFactory().getCar(1);
        car.getCar();
    }
}
