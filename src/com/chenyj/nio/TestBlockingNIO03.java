package com.chenyj.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/28 14:22
 * 陈银杰专属测试
 */
public class TestBlockingNIO03 {

    @Test
    public void client() throws IOException {
        //1获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8899));
        //2切换非阻塞模式
        socketChannel.configureBlocking(false);
        //3分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        /*Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            //4.发送数据给客户端
            buffer.put(scanner.next().getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }*/
        //4.发送数据给客户端
        buffer.put("为什么不行".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        //关闭通道
        socketChannel.close();
    }


    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));
        //2.切换非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3 获取选择器
        Selector selector= Selector.open();
        //4.把通道注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select()>0){

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //是否准备就绪
                if (key.isAcceptable()){
                    SocketChannel sChannel=serverSocketChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    SocketChannel sChannel= (SocketChannel) key.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=sChannel.read(buffer))!=-1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                iterator.remove();
            }
        }



    }
}
