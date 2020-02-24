package com.chenyj.designPattern.prototype;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/2/19 14:12
 * 陈银杰专属测试
 */
public class CarTest {
    public static void main(String[] args) {
        Car car=new Car("吉利","black","small");
        Car car1= (Car) car.clone();
        System.out.println(car);
        System.out.println(car1);
    }
}

class Car implements Cloneable{
    private String name;
    private String color;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Car(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Car car=null;
        try{
            car= (Car) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return car;
    }
}

