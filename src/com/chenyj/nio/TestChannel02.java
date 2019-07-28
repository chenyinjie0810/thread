package com.chenyj.nio;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/28 10:21
 * 陈银杰专属测试
 */
public class TestChannel02 {

    /**
     * 分散读取，聚集写入
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        //获取文件
        RandomAccessFile randomAccessFile=new RandomAccessFile("F:\\面试题\\蚂蚁金服面试分享.txt","rw");
        //获取通道
        FileChannel channel = randomAccessFile.getChannel();
        //分散读取
        ByteBuffer buffer01=ByteBuffer.allocate(100);
        ByteBuffer buffer02=ByteBuffer.allocate(1024);
        //分散写入
        ByteBuffer[] byteBuffers={buffer01,buffer02};
        channel.read(byteBuffers);

        for (ByteBuffer buffer:byteBuffers){
            buffer.flip();
        }
        System.out.println(new String(byteBuffers[0].array(),0,byteBuffers[0].limit()));
        System.out.println("------------");
        System.out.println(new String(byteBuffers[1].array(),0,byteBuffers[1].limit()));

        //聚集写入
        RandomAccessFile randomAccessFile1=new RandomAccessFile("2.txt","rw");
        FileChannel channel1 = randomAccessFile1.getChannel();
        channel1.write(byteBuffers);
    }

    /**
     * @desc: 编码解码
     * @author: chenyj
     * @date: 2019/7/28
     */
    @Test
    public void test02(){
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        Set<String> stringSet = stringCharsetSortedMap.keySet();
        for (String value:stringSet){
            System.out.println(value+"-------"+stringCharsetSortedMap.get(value));
        }
    }

    /**
     * @desc:
     * @author: chenyj
     * @date: 2019/7/28
     */
    @Test
    public void test03() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        //编码
        CharsetEncoder encoder = gbk.newEncoder();
        //解码
        CharsetDecoder decoder= gbk.newDecoder();

        CharBuffer allocate = CharBuffer.allocate(1024);
        allocate.put("老子天下无敌");
        allocate.flip();
        ByteBuffer byteBuffer = encoder.encode(allocate);
        for (int i=0;i<12;i++){
            System.out.println(byteBuffer.get());
        }
        byteBuffer.flip();
        CharBuffer decode = decoder.decode(byteBuffer);
        System.out.println(decode.toString());

        Charset UTF8 = Charset.forName("UTF-8");
        //解码
        byteBuffer.flip();
        CharsetDecoder decoder1= UTF8.newDecoder();
        CharBuffer decode1 = decoder1.decode(byteBuffer);
        System.out.println(decode1.toString());

    }
}
