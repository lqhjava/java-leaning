package com.lqh.main;

import java.util.*;


public class Test {


    public static int find(int a,int b){
        int x = a;
        int y = b;
        int c = 0;
        while(b!= 0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        if(sc.hasNextInt()){
            a = sc.nextInt();
            b = sc.nextInt();
        }

        int c = find(a,b);


            System.out.println((a*b)/c);

    }

}
