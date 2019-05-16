package com.lqh.io;

import java.io.File;

public class TestDemo3 {
    public static void main(String[] args) {
        File file = new File("E:"
                +File.separator+"staio"+File.separator+"May"+File.separator+"10"+File.separator+"hua3.txt");

        //对文件进行操作  要保证文件存在并且是文件
        if(file.exists() && file.isFile()) {
            System.out.println("文件大小"+file.length());
            System.out.println("最后一个修改"+ file.lastModified());

        }

        File file2 = new File("E:"
                +File.separator+"staio"+File.separator+"May"+File.separator+"10");
        //取得文件的目录  保证文件存在并且目录存在
        if(file2.exists() && file2.isDirectory()){
            //取得目录
            File[] re =file2.listFiles();
            for (File file1:re
                 ) {
                System.out.println(file1);
            }
        }
    }
}
