package com.chenyj.socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/18 23:13
 * 陈银杰专属测试
 */
public class Socket02 {

    @Test
    public void client() throws IOException {
        InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
        Socket socket=new Socket(inetAddress,8899);
        FileInputStream fileInputStream=new FileInputStream("timg.jpg");
        OutputStream outputStream=socket.getOutputStream();
        byte[]bytes=new byte[1024];
        int a;
        while ((a=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, a);
        }
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket=new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream=new FileOutputStream("timg1.jpg");
        byte[] bytes=new byte[1024];
        int read;
        while ((read = inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes, 0 ,read);
        }
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

}
