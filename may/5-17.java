package com.lqh.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestDemo6 {
    public static void main(String[] args) throws Exception {
        File file = new File("E:/stdio/hua.txt");
        PrintWriter in = new PrintWriter(new FileOutputStream(file));
        in.println("姓名：xxx");
        in.println("公职：xxx");
        in.close();


        Scanner scan = new Scanner(new FileInputStream(file));
        while(scan.hasNext()){
            String str = scan.next();
            System.out.println(str);
        }
    }
}
