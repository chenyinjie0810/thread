package com.chenyj.designPattern.abstractFactory.impl;

import com.chenyj.designPattern.abstractFactory.Car;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 15:52
 * 陈银杰专属测试
 */
public class bigCar implements Car {
    @Override
    public void getCar() {
        System.out.println("大车");
    }
}
