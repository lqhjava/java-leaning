package com.lqh.dao;

import com.lqh.impl.IQueue;

public class Queueimpl implements IQueue {

    class Node{
        private int data ;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node front;//指向头
    private Node rear;//指向尾巴
    private int useSide;

    public Queueimpl(){
        this.front = null;
        this.rear = null;
        this.useSide = 0;
    }
    @Override
    public boolean empty() {
        return this.useSide == 0;
    }

    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData = this.front.data;
        this.front = this.front.next;
        this.useSide--;
        return oldData;
    }

    @Override
    public void add(int item) {
        Node node = new Node(item);
        if(empty()){
            this.front = node;
            this.rear = node;
            this.useSide++;
        }else {
            this.rear.next = node;
            this.rear = node;
            this.useSide++;
        }
    }

    @Override
    public int size() {
        return this.useSide;
    }
}
