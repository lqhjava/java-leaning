package com.lqh.main;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = null;
        if(sc.hasNext()){
            str = sc.next();
        }
        char[] a = str.toCharArray();
        char[] b = new char[255];
        char[] c = new char[255];
        int i = 0;
        int j = 0;
        int k = 0;
        while(true){
            for(int q= i; i< a.length; i++){
                if((a[i] <= '9') && (a[i] >= '0')){
                    b[j] = a[i];
                    j++;
                    if((i+1) == a.length ){
                        break;
                    }else if(a[i+1] > '9' || a[i+1] < '0'){
                        break;
                    }
//                    if(a[i+1] > '9' || a[i+1] < '0' || i+1 == a.length){
//                        break;
//                    }
                }
            }
            if(j > k){
                c = b;
                k =j;
                j =0;
                i++;
            }else{
                j = 0;
                i++;
            }
            if(i == a.length){
                break;
            }

        }
        for(int x = 0; x < k;x++){
            System.out.print(c[x]);
        }
    }
}
