package com.chenyj.designPattern.factory;

import com.chenyj.designPattern.factory.impl.SmallCar;
import com.chenyj.designPattern.factory.impl.bigCar;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 15:53
 * 陈银杰专属测试
 */
public class CarFactory {
    public Car getCar(Integer type){
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
}
