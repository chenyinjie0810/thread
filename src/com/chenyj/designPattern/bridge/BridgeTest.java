package com.chenyj.designPattern.bridge;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/2/24 15:58
 * 陈银杰专属测试
 */
public class BridgeTest {
    public static void main(String[] args) {
        Car smallCar = new SmallCar(new JiliCar());
        smallCar.open();
        smallCar.driver();
        smallCar.close();
        System.out.println("===============");
        smallCar = new SmallCar(new QiruiCar());
        smallCar.open();
        smallCar.driver();
        smallCar.close();
        System.out.println("===============");
        Car bigCar = new BigCar(new QiruiCar());
        bigCar.open();
        bigCar.driver();
        bigCar.close();
    }
}

interface Brand{
    void open();
    void close();
    void driver();
}

class JiliCar implements Brand{

    @Override
    public void open() {
        System.out.println("吉利汽车开启");
    }

    @Override
    public void close() {
        System.out.println("吉利汽车关闭");
    }

    @Override
    public void driver() {
        System.out.println("吉利汽车兜风");
    }
}

class QiruiCar implements Brand{

    @Override
    public void open() {
        System.out.println("奇瑞汽车开启");
    }

    @Override
    public void close() {
        System.out.println("奇瑞汽车关闭");
    }

    @Override
    public void driver() {
        System.out.println("奇瑞汽车兜风");
    }
}

abstract class Car{
    private Brand brand;

    public Car(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        this.brand.open();
    }
    protected void close(){
        this.brand.close();
    }
    protected void driver(){
        this.brand.driver();
    }
}

class SmallCar extends Car{

    public SmallCar(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("这是小型车");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("这是小型车");
    }

    @Override
    public void driver() {
        super.driver();
        System.out.println("这是小型车");
    }
}

class BigCar extends Car{

    public BigCar(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("这是大型car");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("这是大型car");
    }

    @Override
    public void driver() {
        super.driver();
        System.out.println("这是大型car");
    }
}