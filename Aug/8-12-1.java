package com.lqh.respance;

import java.util.*;

public class Test {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        for(int i = 0;i < k; i++){
            for(int j =i+1;j<input.length;j++ ){
                if(input[j] > input[i]){
                    int tem = input[j];
                    input[j] = input[i];
                    input[i] = tem;
                }
            }
        }

        for(int i = 0; i < k; i++){
            li.add(input[i]);
        }
        return li;
    }

}
