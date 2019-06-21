package com.lqh.dao;

import com.lqh.impl.IStack;

import java.util.Arrays;

public class Stackimpl implements IStack {

    private int[] elem;
    //保存当前可以存储数据的下标
    private int top;
    private int useSide;

    //默认长度
    private static final int DEFAULT_SIZE = 10;

    public Stackimpl(){
        this.elem = new int[DEFAULT_SIZE];
        this.top = 0;
        this.useSide = 0;
    }

    private boolean isFull(){
        return this.top == this.elem.length;
    }
    @Override
    public void push(int item) {
        if(isFull()){
            //数组满了
            throw new UnsupportedOperationException("栈满了");
            //this.elem = Arrays.copyOf(elem,elem.length*2);
        }
        //插入数据
        this.elem[this.top] = item;
        //插入后 ；
        this.top++;
        this.useSide++;
    }

    @Override
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int oldData = this.elem[this.top-1];
        this.top--;
        this.useSide--;
        return oldData;
    }

    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean empty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.useSide;
    }
}
