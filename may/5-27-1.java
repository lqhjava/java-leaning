package com.lqh.main;

import java.util.*;


public class Test {


    public static void  main(String[] args){
            Scanner sc = new Scanner(System.in);
            int w = 0;
            int h = 0;
            if(sc.hasNextInt()){
                w = sc.nextInt();
                h = sc.nextInt();
            }
            int[][] arr = new int[w][h];
            int count =0;
            for(int i =0;i < w; i++){
                for(int j =0; j<h;j++){
                    if(arr[i][j] == 1){
                        continue;
                    }else if(arr[i][j] == 0){
                        count++;
                        if((j+2) <= h-1){
                            arr[i][j+2] = 1;
                        }
                        if((i+2) <= w-1){
                            arr[i+2][j] = 1;
                        }
                    }
                }
            }
        System.out.println(count);
    }

}
