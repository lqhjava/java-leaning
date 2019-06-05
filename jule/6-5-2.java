package com.lqh.main;

import java.util.*;


public class Test {

    public static void math(int n){
        long i = (n*n - n +1);
        String str = "" + i;
        for(int j = 1; j < n;j++){
            i = i+2;
            str = str+"+"+i;
        }
        System.out.println(str);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            math(n);
        }


    }
}
