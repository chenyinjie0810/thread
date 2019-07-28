package com.chenyj.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/28 13:01
 * 陈银杰专属测试
 */
public class TestBlockingNIO01 {

    @Test
    public void client() throws IOException {

        SocketChannel client = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8899));
        FileChannel open = FileChannel.open(Paths.get("timg.jpg"), StandardOpenOption.READ);

        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (open.read(buffer)!=-1){
            buffer.flip();
            client.write(buffer);
            buffer.clear();
        }
        client.shutdownOutput();
        //接受服务端的反馈
        int len=0;
        while ((len=client.read(buffer))!=-1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        open.close();
        client.close();
    }

    @Test
    public void server() throws IOException {
        //接受客户端数据
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));
        SocketChannel accept = serverSocketChannel.accept();
        //创建本地文件
        FileChannel out = FileChannel.open(Paths.get("timg2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (accept.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

        buffer.put("老子天下无敌".getBytes());
        buffer.flip();
        accept.write(buffer);

        accept.close();
        out.close();
        serverSocketChannel.close();


    }
}
