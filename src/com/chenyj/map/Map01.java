package com.chenyj.map;

import org.junit.Test;

import java.util.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/17 20:50
 * 陈银杰专属测试
 */
public class Map01 {

    @Test
    public void test01(){
        Set set=new TreeSet();
        Map<String,Object> map=new Hashtable<>();
        Set<String> stringSets= map.keySet();
        map.put("1","你好");
        map.put("2","1好");
        map.put("3","2好");
        for (String value:stringSets){
            System.out.println(value);
        }
        Collection<Object> values = map.values();
        Iterator<Object> iterators=values.iterator();
        while (iterators.hasNext()){
            iterators.next();
            iterators.remove();
        }
        for (Object value:values){
            System.out.println(value.toString());
        }
    }
}
