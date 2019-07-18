package com.chenyj.File;

import org.junit.Test;

import javax.annotation.processing.Filer;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/17 17:23
 * 陈银杰专属测试
 */
public class File01 {
    public static void main(String[] args) throws IOException {
        File file=new File("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/省对接字段回填.sql");
        FileInputStream inputStream=new FileInputStream(file);
        int i=inputStream.read();
        while (i > 0){
            System.out.println((char)i);
            i = inputStream.read();
        }
    }

    @Test
    public void test01() throws IOException {
        File file=new File("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/省对接字段回填.sql");
        String[] list = file.list();
        Path path= Paths.get("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/省对接字段回填.sql");
        Files.copy(path,new FileOutputStream("F://shangqiuworkspance/test.sql"));
        for (String value:list){
            System.out.println(value);
        }
    }

    @Test
    public void test02() throws IOException {
        File file=new File("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/省对接字段回填.sql");
        File file1=new File("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/ceshi.txt");
        if (!file1.exists()){
           file1.mkdirs();
        }
    }

    @Test
    public void test03() {
        File file=new File("F://shangqiuworkspance/zfsoft_gov_server_operational_platform_standard_v2.0/DOC/省对接字段回填.sql");
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
            int a;
            while ((a=fileReader.read())!=-1){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test04(){
        File file=new File("test.txt");
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(file,true);
            fileWriter.write("我喜欢你啊\n");
            fileWriter.write("因为你与众不同啊");
            System.out.println( fileWriter.getEncoding());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test05(){
        try {
            FileReader fileReader=new FileReader("test.txt");
            FileWriter fileWriter=new FileWriter("test01.txt");

            char[] chars=new char[1024];
            int a;
            while ((a=fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,a);
                System.out.println(chars);
                System.out.println(a);
            }
            fileReader.close();;
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06(){
        FileInputStream fileInputStream= null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream("test.txt");
            fileOutputStream = new FileOutputStream("test02.txt");
            byte[] bytes=new byte[5];
            int a;
            while ((a=fileInputStream.read(bytes))!=-1){
               fileOutputStream.write(bytes,0,a);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null==fileOutputStream){
                    fileOutputStream.close();
                }
                if (null==fileInputStream){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test07() {

        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            FileInputStream fileInputStream=new FileInputStream("test.txt");
            FileOutputStream  fileOutputStream = new FileOutputStream("test03.txt");

            bufferedInputStream=new BufferedInputStream(fileInputStream);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte[] bytes=new byte[1024];
            int a;
            while ((a=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Test
    public void test08() {

        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            FileReader fileReader=new FileReader("test.txt");
            FileWriter fileWriter = new FileWriter("test04.txt");

            bufferedReader=new BufferedReader(fileReader);
            bufferedWriter=new BufferedWriter(fileWriter);
            /*char[] chars=new char[1024];
            int a;
            while ((a=bufferedReader.read(chars))!=-1){
                bufferedWriter.write(chars,0,a);
            }*/
            String a;
            while ((a=bufferedReader.readLine()) != null){
                bufferedWriter.write(a+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
