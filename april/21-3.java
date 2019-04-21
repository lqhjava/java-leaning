package com.lqh.main;

import com.lqh.dao.Queueimpl;

/*
* 用队列实现栈
*/
public class TestMyStack {
    private Queueimpl q1;
    private Queueimpl q2;
    private int useSide;

    public TestMyStack() {
        q1 = new Queueimpl();
        q2 = new Queueimpl();
        this.useSide = 0;
    }

    public void push(int x) {
//        if(q1.empty() && q2.empty()){
//            q1.add(x);
//        }
        if(q1.empty()){
            q2.add(x);
        }else{
            q1.add(x);
        }
        this.useSide++;
    }

    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int data = 0;
        if(q1.empty()){
            for (int i = 0; i <this.useSide-1 ; i++) {
                q1.add(q2.poll());
            }
            this.useSide--;
            return data = q2.poll();
        }else{
            for (int i = 0; i <this.useSide-1 ; i++) {
                q2.add(q1.poll());
            }
            this.useSide--;
            return data = q2.poll();
        }
    }

    public int top() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int re = 0;
        if(q1.empty()){
            for (int i = 0; i <q2.size()-1 ; i++) {
                q1.add(q2.poll());
            }
            re = q2.poll();
            q1.add(q2.poll());
            return re;
        }else{
            for (int i = 0; i <q2.size()-1 ; i++) {
                q2.add(q1.poll());
            }
            re = q1.poll();
            q2.add(q1.poll());
            return re;
        }
    }

    public boolean empty() {
            return this.useSide == 0;
    }

}
