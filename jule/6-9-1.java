package com.lqh.io;
import java.util.*;

public class Test {


    public static char[] find(String str, int n){
        char[] arr = new char[n];
        int count = 0;
        int k =0;
        for(int i = 0;i < (str.length()-n);i++){
            count = 0 ;
            for(int j = i;j < (i +n);j++){
                if(str.charAt(j) == 'G' || str.charAt(j) == 'C'){
                    count++;
                }
            }
            if(count > k ){
                array(str,n,i,arr);
                k =count;
            }
        }
        return arr;
    }

    public static void array(String str,int n,int i,char[] arr){
        int top = 0;
        for(int j =i;j < (i+n);j++ ){
            arr[top++] = str.charAt(j);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = null;
        int n = 0;
        if(sc.hasNextLine()){

            str = sc.nextLine();

            n = Integer.parseInt(sc.nextLine());

            char[] arr = find(str,n);
            System.out.println(String.valueOf(arr));
        }

    }
}
