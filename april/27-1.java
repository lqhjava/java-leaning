package com.lqh.main;

public class FindA {

    public static char firstThreeTimes(String str){
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length ; i++) {
            int count = 0;
            for (int j = i+1; j < c.length ; j++) {
                if((c[i] == c[j]) && (c[i] != ' ')){
                    count++;
                }
                if(count == 2){
                    return c[i];
                }
            }
        }
        throw new UnsupportedOperationException("not find");
    }

    public static void main(String[] args) {
        String str = "asdfag hja kla sd";
        String sr1 = "asdfghjk";
        System.out.println(firstThreeTimes(str));
        //System.out.println(firstThreeTimes(sr1));
    }
}
