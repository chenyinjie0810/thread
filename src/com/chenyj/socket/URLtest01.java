package com.chenyj.socket;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/19 23:22
 * 陈银杰专属测试
 */
public class URLtest01 {


    @Test
    public void test01(){
        URL url;
        URLConnection connection;
        InputStream inputStream =null;
        FileOutputStream outputStream = null;
        try {
            url=new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563560125901&di=bee86dda9e6cf9293156d277c6cc90bf&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F14%2F20180714211943_vlvpq.jpg");
            connection = url.openConnection();
            String protocol = url.getProtocol();//协议名
            String host = url.getHost();//主机名
            String path = url.getPath();//文件路径
            int port = url.getPort();//端口号
            String file = url.getFile();//文件名
            String query = url.getQuery();//查询名
            connection.connect();
            inputStream=connection.getInputStream();
            outputStream=new FileOutputStream("迪丽热巴.jpg");
            byte[] bytes=new byte[1024];
            int a;
            while ((a=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,a);
            }
            System.out.println("下载完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
