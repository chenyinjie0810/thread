package com.chenyj.File;

import org.junit.Test;

import java.io.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/18 20:42
 * 陈银杰专属测试
 */
public class File02 {

    @Test
    public void test01() throws IOException {
        File file01=new File("test05.txt");
        File file02=new File("test06.txt");

        FileInputStream fileInputStream=new FileInputStream(file01);
        FileOutputStream fileOutputStream=new FileOutputStream(file02);

        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"gbk");
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"UTF-8");

        char[] chars=new char[5];
        int a;
        while ((a=inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0, a);
        }
        outputStreamWriter.close();
        inputStreamReader.close();


    }

}
