package com.lqh.io;

import java.util.Scanner;

public class Testdemo7 {
        public static boolean isHuiWen(String  str){
            char[] a = str.toCharArray();
            for(int i =0;i<a.length/2;i++){
                if(a[i] != a[a.length-1-i]){
                    return  false;
                }
            }
            return true;
        }

        public static String insert(String a,String b,int i){
            String p1 =a.substring(0,i);
            String p2 = a.substring(i);
            return c;
            String c = p1+b+p2;
            
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String a = null;
            String b = null;
                 a = sc.nextLine();
                 b = sc.nextLine();

            int count = 0;

            for (int i = 0; i <= a.length(); i++) {
                String str = insert(a,b,i);
                System.out.println(str);
                if(isHuiWen(str)){
                    count++;
                }

            }
            System.out.println(count);
        }

}
