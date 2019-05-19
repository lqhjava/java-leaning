package com.lqh.io;

import java.io.*;

import static java.lang.System.out;

public class TestDemo1 {


    public static void main(String[] args) throws IOException {
        File file = new File("E:/stdio/hua.txt");

            //取得相应终端的输出流
            OutputStream outer = new FileOutputStream(file);
            //将数据通过输出流输出
            outer.write("hello word\n".getBytes());
            //关闭输出流
            outer.close();





        //listFiles(file);
    }






    private static void listFiles(File file){

        //找指定目录下的所有文件，如果遇到文件，则进入找子文件
        File[] a = file.listFiles();
        for (File file1:a
             ) {
            if(file1.isDirectory()){
                listFiles(file1);
            }else{
                out.println(file1);
            }
        }
    }
}
