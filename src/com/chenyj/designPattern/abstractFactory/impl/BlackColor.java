package com.chenyj.designPattern.abstractFactory.impl;

import com.chenyj.designPattern.abstractFactory.Color;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/15 16:38
 * 陈银杰专属测试
 */
public class BlackColor implements Color {
    @Override
    public void getColor() {
        System.out.println("黑色车");
    }
}
