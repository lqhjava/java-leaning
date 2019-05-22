package com.lqh.main;

import java.util.Scanner;

public class Test {
    public static boolean chkParenthesis(String A) {
        // write code here

        int top = 0;
        char[] b = new char[A.length()];
        char[] a=A.toCharArray();

        for(int i = 0;i< A.length();i++){

            if(a[i] == '(' || a[i] == '{' || a[i] == '['){
                b[top] = a[i];
                top++;
            }
            if(a[i] == ')' || a[i] == '}' || a[i] == ']'){
                int x = top-1;
                if(top == 0){
                    return false;
                }
                if((a[i] == ')' && b[x] == '(')
                        || (a[i] == '}' && b[x] == '{')
                        || (a[i] == ']' && b[x] == '[') ){
                    top --;
                }else{
                    return false;
                }
            }
        }
        if(top != 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String sstr = "()a{}[]";
        System.out.println(chkParenthesis(sstr));

    }
}
