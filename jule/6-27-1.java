package com.lqh.main;
import java.util.*;

public class Day {
    public static void deal(char[] str, int[] arr) {
        int a = str[2]-'0';
        int b = str[4]-'0';
        if (str[0] == 'Q') {
            int tem = 0;
            for (int i = a-1; i <= b-1; i++) {
                if (arr[i] > tem) {
                    tem = arr[i];
                }
            }
            System.out.println(tem);
        }
        if (str[0] == 'U') {
            arr[a-1] = b-1;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =0;
        int m = 0;
        int a= 0;
        int b = 0;
        if(sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            //System.out.println(m);
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            for (int j = 0; j <m; j++) {
                char[] array = sc.nextLine().toCharArray();
                System.out.println(array);
                //deal(array,arr);
            }
        }
    }
}

