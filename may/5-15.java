package com.lqh.io;

import java.io.*;

public class TestDemo4 {
    public static void main(String[] args) throws Exception {
        File file = new File("E:/stdio/hua.txt");

        //System.out.println(file.exists());


        //输出流
        //取得对象
        OutputStream out = new FileOutputStream(file);
        //输出内容
        String msg = "com.lqh.www";
        //将内容变为字节数组
        out.write(msg.getBytes(),0,5);
        //关闭输出
        out.close();

        //输入流
        //保证对象存在
        if (file.exists()) {
            //取的对象
            InputStream input = new FileInputStream(file);
            //读取内容
            byte[] data = new byte[1024];
            //此时data的长度大于你要取的数据长度，可以一次就取完
            int len = input.read(data);//将数据存入导数组中去  len为数据的长度
            String re = new String(data, 0, len);//将数组转为字符串
            //System.out.println(len); len=11
            System.out.println("读取内容"+re);

            //关闭输出流
            input.close();

            //


        }
    }
}
