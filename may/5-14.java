package com.lqh.io;

import java.io.*;

public class TestDemo5 {
    public static void main(String[] args) throws IOException {
        //System.getProperties().list(System.out);
        String str = "hello Word";

        //取得目标对象
        InputStream in = new ByteArrayInputStream(str.getBytes());
        //
        OutputStream out = new ByteArrayOutputStream();

        int len =0;
        while((len = in.read()) !=-1){//一次读取一个
            //变为大写
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        //关闭流
        in.close();
        out.close();
    }
}
