package com.chenyj.designPattern.abstractFactory;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:46
 * 陈银杰专属测试
 */
public class FactoryProducer {

    public CarAbstractFactory getCarAbstractFactory(String type){
        if ("color".equals(type)){
            return new ColorFactory();
        }else if ("car".equals(type)){
            return new CarFactory();
        }
        return null;
    }
}
