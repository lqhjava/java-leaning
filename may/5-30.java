package com.lqh.main;

import java.util.*;
public class TestDemo4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNextInt()){
            n = sc.nextInt();
        }
        int count = 0;
        while(n > 0){
            count  = count + n/5;
            n = n/5;
        }
        System.out.println(count);
    }
}
