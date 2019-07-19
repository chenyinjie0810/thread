package com.chenyj.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/19 20:47
 * 陈银杰专属测试
 */
public class UDPtest01 {


    @Test
    public void test01() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        InetAddress inetAddress=InetAddress.getLocalHost();
        String s="你好啊，老子是天下无敌的陈银杰";
        DatagramPacket datagramPacket=new DatagramPacket(s.getBytes(),0,s.getBytes().length,inetAddress,8899);
        socket.send(datagramPacket);
        socket.close();
    }

    @Test
    public void test02() throws IOException {
        DatagramSocket socket=new DatagramSocket(8899);
        byte[] bytes=new byte[100];
        DatagramPacket datagramPacket=new DatagramPacket(bytes,0, bytes.length);
        socket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        socket.close();
    }

}
