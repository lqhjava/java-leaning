package com.lqh.main;

import com.lqh.dao.Stackimpl;

public class MinStack {
    private Stackimpl s1;
    private Stackimpl min;

    public MinStack(){
        s1 = new Stackimpl();
        min = new Stackimpl();
    }

    public void push9(int x){
        s1.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            if(x <= min.peek()){
                min.push(x);
            }
        }
    }

    public void pop(){
        if(!s1.empty()){
            int tem = s1.pop();
            if(tem == min.peek()){
                min.pop();
            }
        }
    }

    public int top(){
        if (s1.empty()){
            return -1;
        }
        return s1.peek();
    }

    public int getMin(){
        if(min.empty()){
            return -1;
        }
        return min.peek();
    }
}
