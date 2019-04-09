package com.lqh.dao;

import com.lqh.impl.ILinked;

/*
    无头单向链表
 */
public class TestLinked implements ILinked {

    //
    class Node {
        //保存数据
        private int data;
        //指向下一个节点
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //头节点
    private Node head;
    public TestLinked(){
        this.head = null;
    }

    @Override
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        //第一次插入
        if(this.head == null){
            this.head = node;
        }else{
            //进行头插
            node.next = this.head;
            this.head = node;
        }

    }

    @Override
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur  = this.head;
        //第一次插入
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    private void isIndexOk(int index){
        if(index < 0||index >getLength()){
            throw new NullPointerException("下标不合法");
        }
    }
    private Node findIndex(int index){
        isIndexOk(index);
        Node cur = this.head;
        int count = 0;
        while(count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        //如果index= 0,相当于头插
        if(index == 1){
            addFirst(data);
        }else {
            //找到index位置的上一个节点
            Node cur = findIndex(index);
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur.next != null ){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node findKeyBefore(int key){
        Node cur = this.head;
        Node curNext = cur.next;
        while(curNext != null){
            if(curNext.data == key){
                return cur;
            }
            cur = curNext;
            curNext = cur.next;
        }
        //没有找到key的上一个节点
        return null;
    }
    @Override
    //删除一个节点
    public int remove(int key) {
        int oldData = 0;
        //如果删除的是头节点
        Node cur = findKeyBefore(key);
        if(key == this.head.data){
            //保存删除的节点数据
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }else if(cur == null){
            //没找到key的上一个节点
            throw new UnsupportedOperationException("链表里没有key");
        }else{
            Node curNext = cur.next;
            oldData = curNext.data;
            cur.next = curNext.next;
            return oldData;
        }

    }

    @Override
    public void removeAllKey(int key) {
        Node cur =this.head;
        Node curNext = cur.next;
        while(curNext != null){
            //先删除头节点以后的key
            if(curNext.data == key){
                cur.next = curNext.next;
                curNext = cur.next;
            }else{
                cur = cur.next;
                curNext = cur.next;
            }
        }
        //判断头节点
        if(this.head.data == key){
            this.head = this.head.next;
        }

    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        if(this.head == null ){
            System.out.println("没有数据");
        }else{
            while(cur != null){
                System.out.print(cur.data+"  ");
                cur = cur.next;
            }
            System.out.println();
        }

    }

    @Override
    public void clear() {
        while (this.head != null){
            Node cur = this.head.next;
            this.head = null;
            this.head = cur;
        }

    }
}
