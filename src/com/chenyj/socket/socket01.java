package com.chenyj.socket;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/18 21:49
 * 陈银杰专属测试
 */
public class socket01 {


    @Test
    public void test01(){
        try {
            InetAddress inetAddress=InetAddress.getByName("www.baidu.com");

            InetAddress inetAddress1=InetAddress.getLocalHost();
            System.out.println(inetAddress1);
            System.out.println(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void client(){
        InetAddress inetAddress;
        Socket socket=null;
        OutputStream outputStream = null;
        try {
            inetAddress = InetAddress.getByName("127.0.0.1");
            socket=new Socket(inetAddress, 8899);
            outputStream=socket.getOutputStream();
            outputStream.write("你好，我是陈银杰".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
               if (outputStream!=null){
                   outputStream.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server(){
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream inputStream=null;
        ByteArrayOutputStream byteArrayOutputStream=null;
        try {
            serverSocket=new ServerSocket(8899);
            socket=serverSocket.accept();
            inputStream = socket.getInputStream();
            byteArrayOutputStream=new ByteArrayOutputStream();

            byte[] bytes=new byte[5];
            int a;
            while ((a=inputStream.read(bytes))!=-1){
                byteArrayOutputStream.write(bytes, 0, a);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
