package com.lqh.main;

import java.util.*;


public class Test {


    public static void count(String str){
        int[] arr = new int[10];
        for(int i = 0;i < 10;i++){
            arr[i] = 0;
        }
        for(int i = 0; i < str.length();i++ ){
            for(int z = 0; z < arr.length;z++){
                if(((str.charAt(i))-'0') == z){
                    arr[z] = arr[z]+1;
                }
            }
        }
        for(int j = 0; j< 10;j++){
            if(arr[j] != 0) {
                System.out.println(j + ":" + arr[j]);

            }

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = null;
        while(sc.hasNextLine()){
            str = sc.nextLine();
            count(str);

        }
    }

}
