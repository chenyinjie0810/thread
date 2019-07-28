package com.chenyj.nio;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/28 15:06
 * 陈银杰专属测试
 */
public class TestBlockingNIO04 {



    @Test
    public void client() throws IOException {
        DatagramChannel dc=DatagramChannel.open();
        dc.configureBlocking(false);

        ByteBuffer buffer=ByteBuffer.allocate(1024);
        Scanner scanner=new Scanner(System.in);

        /*while (scanner.hasNext()){
            buffer.put(scanner.next().getBytes());
            buffer.flip();
            dc.send(buffer,new InetSocketAddress("127.0.0.1",8899));
            buffer.clear();
        }*/
        buffer.put("我是很喜欢你了".getBytes());
        buffer.flip();
        dc.send(buffer,new InetSocketAddress("127.0.0.1",8899));
        buffer.clear();
        dc.close();
    }

    @Test
    public void server() throws IOException {
        DatagramChannel dc=DatagramChannel.open();
        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(8899));

        Selector selector=Selector.open();
        dc.register(selector, SelectionKey.OP_READ);

        while (selector.select()>0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isReadable()){
                    ByteBuffer buffer=ByteBuffer.allocate(1024);

                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    buffer.clear();
                }
            }
            iterator.remove();
        }

    }
}
