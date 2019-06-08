package com.lqh.io;
import java.util.*;

public class Test {
    public static void find(int[] arr){
        while(paixu(arr)){
            print(arr);
        }
    }
    public static boolean paixu(int[] arr){
        int i = 0;
        for(i = arr.length-1-1;i >= 0;i--){
            if(i == 0){
                if(arr[i] < arr[i+1]){
                    swap(arr,i,big(arr,arr[i]));
                    break;
                }else{
                    return false;
                }
            }else if(arr[i] < arr[i+1]){
                swap(arr,i,big(arr,arr[i]));
                break;
            }
        }
        pX(arr,i);
        return true;
    }
    public static int big(int[] arr,int i){
        int j = 0;
        for(j =arr.length-1;j > 0;j-- ){
            if(arr[j] > i){
                break;
            }
        }
        return j;
    }
    public static void pX(int[] arr,int n){
        for(int i = (n+1);i < arr.length;i++){
            for(int j = (i+1);j<arr.length;j++){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tem = 0;
        tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void  main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ;i < n ;i++){
                arr[i] = sc.nextInt();
            }
            print(arr);
            find(arr);

        }

    }
}
