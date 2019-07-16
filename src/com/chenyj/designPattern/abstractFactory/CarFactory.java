package com.chenyj.designPattern.abstractFactory;

import com.chenyj.designPattern.abstractFactory.impl.SmallCar;
import com.chenyj.designPattern.abstractFactory.impl.bigCar;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:43
 * 陈银杰专属测试
 */
public class CarFactory extends CarAbstractFactory {
    @Override
    Car getCar(Integer type) {
        if (null==type){
            return null;
        }
        if (1==type){
            return new SmallCar();
        }
        if (2==type){
            return new bigCar();
        }
        return null;
    }

    @Override
    Color getColor(Integer b) {
        return null;
    }
}
