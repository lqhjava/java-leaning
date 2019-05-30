package com.lqh.main;

import java.util.*;


public class Test {


    public static int countWays(int x, int y) {
        // write code here
        int i = 1;
        int j = 1;
        return count(x,y,i,j);
    }

    public static int count(int x, int y,int i,int j){
        if(i == x && j == y){
            return 1;
        }
        if(i > x || j>y){
            return 0;
        }
        if(i == x){
            return count(x,y,i,j+1);
        }
        if(j == y){
            return count(x,y,i+1,j);
        }
        return count(x,y,i+1,j)+count(x,y,i,j+1);
    }

    public static void main(String[] args) {
        System.out.println(countWays(6, 4));
    }

}
