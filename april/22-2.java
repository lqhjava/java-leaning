package com.lqh.dao;

public class MyCircularQueue {
    private int front;//头
    private int rear;//尾巴
    private int[] elem;//数组
    private int useSide;//有效数据
    //private static final int DEFAULT_SIZE;

    public MyCircularQueue(int k){
        this.elem =new int[k];
        this.front = 0;
        this.rear = 0;
        this.useSide = 0;
    }

    public  boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[rear] = value;
        this.useSide++;
        this.rear =(this.rear +1)%this.elem.length;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        int data = this.elem[front];
        this.front = (this.front + 1)%this.elem.length;
        this.useSide--;
        return true;
    }

    public  int Front(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.elem[this.front];
    }
    public  int Rear(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        if(this.rear == 0){
            return this.elem[this.elem.length-1];
        }else{
            return this.elem[this.rear-1];
        }
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        if((this.rear+1)%this.elem.length == this.front){
            return true;
        }
        return false;
    }
}
