package com.chenyj.designPattern.abstractFactory.impl;

import com.chenyj.designPattern.abstractFactory.Car;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 15:51
 * 陈银杰专属测试
 */
public class SmallCar implements Car {
    @Override
    public void getCar() {
        System.out.println("小轿车");
    }
}
