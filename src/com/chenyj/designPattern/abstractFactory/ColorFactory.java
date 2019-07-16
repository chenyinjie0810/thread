package com.chenyj.designPattern.abstractFactory;

import com.chenyj.designPattern.abstractFactory.impl.BlackColor;
import com.chenyj.designPattern.abstractFactory.impl.BlueColor;
import com.chenyj.designPattern.abstractFactory.impl.bigCar;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:44
 * 陈银杰专属测试
 */
public class ColorFactory extends CarAbstractFactory {
    @Override
    Car getCar(Integer a) {
        return null;
    }

    @Override
    Color getColor(Integer type) {
        if (null==type){
            return null;
        }
        if (1==type){
            return new BlackColor();
        }
        if (2==type){
            return new BlueColor();
        }
        return null;

    }
}
