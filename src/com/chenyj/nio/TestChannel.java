package com.chenyj.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/25 22:42
 * 陈银杰专属测试
 */
public class TestChannel {

    @Test
    public void test02() throws IOException {
        long l = System.currentTimeMillis();
        FileChannel inChannel=FileChannel.open(Paths.get("E:\\迅雷下载\\[电影天堂www.dy2018.com]无名之辈HD国语中字.mkv"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("E:\\迅雷下载\\[电影天堂www.dy2018.com]无名之辈HD国语中字1.mkv"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.close();
        inChannel.close();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    /**
     * 使用管道复制文件
     */
    @Test
    public void test01(){
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;

        FileChannel inChannel=null;
        FileChannel outChannel=null;

        try {
            //获取文件
            fileInputStream=new FileInputStream("迪丽热巴.jpg");
            fileOutputStream=new FileOutputStream("迪丽热巴2.jpg");

            //获取通道
            inChannel=fileInputStream.getChannel();
            outChannel=fileOutputStream.getChannel();
            //为缓冲区指定大小
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            while (inChannel.read(byteBuffer)!=-1){
                //切换读数据模式
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (outChannel!=null){
                    outChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inChannel!=null){
                    inChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileInputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
