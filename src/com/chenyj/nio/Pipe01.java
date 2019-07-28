package com.chenyj.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/28 15:30
 * 陈银杰专属测试
 */
public class Pipe01 {

    @Test
    public void test01() throws IOException {
        Pipe pipe=Pipe.open();
        Pipe.SinkChannel channel=pipe.sink();
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        buffer.put("老子天下无敌".getBytes());
        buffer.flip();
        channel.write(buffer);

        Pipe.SourceChannel sourceChannel=pipe.source();
        buffer.flip();
        int len=sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(),0,len));

        sourceChannel.close();
        channel.close();
    }
}
