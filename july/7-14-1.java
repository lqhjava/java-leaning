package com.lqh.main;

import java.util.*;


public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        if(sc.hasNextInt()){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
        }
        if((a+c)%2 == 1 || (b+d)%2 == 1 || (d-b)%2 == 1 ){
            System.out.println("No");
        }else{
            if((a+c) > 0 && (b+d) > 0 && (d-b) > 0){
                System.out.println((a+c)/2+" "+(b+d)/2+" "+((d-b)/2));
            }else{
                System.out.println("No");
        }
    }


}
