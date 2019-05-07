package com.lqh.io;

import java.io.File;
import java.io.IOException;

public class TestIO {
    public static void main(String[] args) {
        //文件可以不存在
        //File.separator  file的常量 代表分隔符
        File file = new File("E:"+File.separator+"stdio"+File.separator+"hua.txt");

        try {
            //文件操作

            if(file.exists()){
                //文件存在  删除
                file.delete();
            }
                //文件不存在 创建
                file.createNewFile();


            //创建文件
            //file.createNewFile();

            //判断文件是否存在
            //file.exists();

            //删除文件
            //file.delete();

            //目录操作
            //判断父文件夹书否存在
//            if(!file.getParentFile().exists()){
//                //不存在 创建
//                file.getParentFile().mkdirs();
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
