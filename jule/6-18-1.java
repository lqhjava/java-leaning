package com.lqh.main;
import java.util.*;

public class Day {
    public static void deal(int[] arr){
        int sum1 =0;
        int sum2  = 0;
        int flag = 1;
        int count  =0;
        int count2 = 0;
        double sum3 = 0;
        int re = 0;
        for(int i =0;i <arr.length;i++){
            if((arr[i]%5 == 0) &(arr[i]%2 == 0)){
                sum1 = sum1 +arr[i];
            }
            if(arr[i]%5 ==1){
                sum2 = sum2 + flag*arr[i];
                flag = flag*-1;
            }
            if(arr[i]%5 == 2){
                count++;
            }
            if(arr[i]%5 == 3){
                sum3 = sum3+arr[i];
                count2++;
            }
            if(arr[i]%5 == 4){
                if(arr[i] > re){
                    re=arr[i];
                }
            }
        }
        sum3 = sum3/count2;
        System.out.println(sum1+" "+sum2+" "+count+" "+String.format("%.1f",sum3)+" "+re);

    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i <arr.length;i++){
                arr[i] = sc.nextInt();
            }
            deal(arr);
        }
    }
}
