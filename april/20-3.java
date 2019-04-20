package com.lqh.main;

public class TestDemo {
    //可变参数
    
    public static int add(int...val){
        int re = 0;
        for (int i = 0;i < val.length;i++) {
            re = re + val[i];
        }
        return re;
    }
    public static void main(String[] args) {
        System.out.println(add(2,3));
        System.out.println(add(1,2,3,4,5,6,7,9,7,8));
    }
}
