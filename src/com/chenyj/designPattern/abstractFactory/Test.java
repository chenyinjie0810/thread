package com.chenyj.designPattern.abstractFactory;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:50
 * 陈银杰专属测试
 */
public class Test {
    public static void main(String[] args) {
        CarAbstractFactory colorAbstractFactory=new FactoryProducer().getCarAbstractFactory("color");
        Color color=colorAbstractFactory.getColor(1);
        color.getColor();

        CarAbstractFactory carAbstractFactory=new FactoryProducer().getCarAbstractFactory("car");
        Car car=carAbstractFactory.getCar(1);
        car.getCar();
    }
}
