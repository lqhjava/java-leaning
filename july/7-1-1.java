package com.lqh.main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test1 {
    public static double deal(int n){
        if(n >= 90 && n <= 100){
            return 4.0;
        }
        if(n >= 85 && n <= 89){
            return 3.7;
        }
        if(n >= 82 && n <= 84){
            return 3.3;
        }
        if(n >= 78 && n <= 81){
            return 3.0;
        }
        if(n >= 75 && n <= 77){
            return 2.7;
        }
        if(n >= 72 && n <= 74){
            return 2.3;
        }
        if(n >= 68 && n <= 71){
            return 2.0;
        }
        if(n >= 64 && n <= 67){
            return 1.5;
        }
        if(n >= 60 && n <= 63){
            return 1.0;
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNext()){
            n =sc.nextInt();
            double[] arr = new double[n];
            double sum1 = 0;
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
                sum1 = sum1 +arr[i];
            }
            double sum = 0;
            for(int j = 0;j<n;j++){
                arr[j] = arr[j]*deal(sc.nextInt());
                sum = sum+arr[j];
            }
            System.out.println(sum1);
            System.out.println(sum);
            DecimalFormat df   = new DecimalFormat("######0.00");
            //df.format(sum/sum1);
            System.out.println(df.format(sum/sum1));
        }
    }
}
