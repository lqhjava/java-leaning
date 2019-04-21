package com.lqh.main;

import com.lqh.dao.Stackimpl;

public class TestMyQueue {
    private Stackimpl q1;
    private Stackimpl q2;
    private int useSide;

    public TestMyQueue(){
        q1 = new Stackimpl();
        q2 = new Stackimpl();
        this.useSide = 0;
    }

    public void push(int x) {
        q1.push(x);
    }

    public int pop() {
        int data = 0;
        if(q2.empty()){
            //把q1里的数据放入q2
            while(!q1.empty()){
                q2.push(q1.pop());
            }
        }
        if(!q2.empty()){
            //出q2里的数据
           data =  q2.pop();
        }
        return data;
    }

    public int peek() {
        int re = 0;
        if(q2.empty()){
            //把q1里的数据放入q2
            while(!q1.empty()){
                q2.push(q1.pop());
            }
        }
        if(!q2.empty()){
            //出q2里的数据
            re =  q2.peek();
        }
        return re;
    }

    public boolean empty() {
        if(q1.empty() && q2.empty()){
            return true;
        }
        return false;
    }
}
