package com.lqh.main;

import java.util.*;
public class TestDemo4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //List<Inter> li = new ArrayList<Integer>();
        int[] arr = new int[100];
        int n = 0;
        while(sc.hasNextInt()){
            arr[n] = sc.nextInt();
            n++;
        }
        int tem = 0;

        for(int i =0;i < arr[n-1];i++){
            for(int j =i+1;j < n-2;j++ ){
                if(arr[i] > arr[j]){
                    tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        for(int z = 0; z < arr[n-1];z++){
            System.out.print(arr[z]+" ");
        }




    }
}
