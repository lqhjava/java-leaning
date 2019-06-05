package com.lqh.main;

import java.util.*;


public class Test {



    public static void math(int[] arr1){
        int[] arr2 = new int[50];
        int i =0;
        int k =0;
        for (int j = 0; j < arr1.length; j++) {
            if(arr1[j] != 0){
                for ( k = 0; k < arr1[j]; k++) {
                    arr2[i++] = j;
                }
            }
        }

        int tem = 0;
        int g = 0;
        for( g = 0;g<i;g++){
            if(arr2[g] != 0){
                tem = arr2[g];
                arr2[g] = arr2[0];
                arr2[0] = tem;
                //tem = 1;
                break;
            }
        }
        if( i == 0 ){
            System.out.println(0);
        }else{
            for (int d = 0; d < i; d++) {
                System.out.print(arr2[d]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[10];
        while(sc.hasNextLine()){
            for (int x = 0; x < 10; x++) {
                arr1[x] = sc.nextInt();
            }
            math(arr1);
        }

    }
}
