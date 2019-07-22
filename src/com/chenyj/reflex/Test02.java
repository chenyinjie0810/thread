package com.chenyj.reflex;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/21 18:34
 * 陈银杰专属测试
 */
 class Test01 {
    public String id;
    private String name;

    public Test01(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test01() {
    }

    @Override
    public String toString() {
        return "Test01{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public void show(){
        System.out.println("老子天下无敌");
    }

    private Object show(String value){
        System.out.println("老子天下无敌"+value);
        return value;
    }

    private Test01(String name) {
        this.name = name;
    }
}

public class Test02{
    
    @Test
    public void test03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class classTest01=Test01.class;
        //获取构造器
        Constructor constructor = classTest01.getConstructor(String.class, String.class);
        Object object= constructor.newInstance("陈银杰","老子天下无敌");
        Test01 test01= (Test01) object;
        System.out.println(object.toString());
        Field id = classTest01.getDeclaredField("id");
        id.set(test01,"齐天大圣");

        System.out.println(test01.toString());
        Method declaredMethod = classTest01.getDeclaredMethod("show");
        declaredMethod.invoke(test01);

        //调用私有构造器
        Constructor declaredConstructor = classTest01.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Test01 test011= (Test01) declaredConstructor.newInstance("你好");
        System.out.println(test011);
        //获取私有属性
        Field id1 = classTest01.getDeclaredField("name");
        id1.setAccessible(true);
        id1.set(test011,"陈小杰先生");
        System.out.println(test011);

        //调用私有的方法
        Method show = classTest01.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object invoke = show.invoke(test01, "，真的吗？？");
        System.out.println(invoke);

    }
}
