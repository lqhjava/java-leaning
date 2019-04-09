package com.lqh.dao;

import com.lqh.impl.ICLinked;

/*
    带头循环链表
 */
public class TestLinked implements ICLinked {
    //创建节点类型
    class Node{
        private int data;
        private Node next;

        public Node(){
            this.data = -1;
        }
        public Node(int data){
            this.data = data;
        }
    }
    //创建头节点
    private Node head;

    public TestLinked(){
        this.head = new Node();
        //只有一个节点时，自己指向自己
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;

    }

    @Override
    public void addLast(int data) {
        //找到尾节点
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next != this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;

    }

    private void isIndexOk(int index){
        if(index < 0||index > getLength()){
            throw new NullPointerException("下标不合法");
        }
    }
    private Node findIndexBefor(int index){
        isIndexOk(index);
        Node cur = this.head;
        int count = 0;
        while(index > count){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        //找到index的上一个节点
        Node cur = findIndexBefor(index);
        node.next = cur.next;
        cur.next = node;
        return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node findKeyBefore(int key){
        Node cur = this.head;
        while(cur.next != this.head){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        //找到key的上一个节点
        Node cur = findKeyBefore(key);
        if(cur == null){
            throw new UnsupportedOperationException("key不存在");
        }else{
            Node curNext = cur.next;
            cur.next = curNext.next;
        }
        return 0;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        Node curNext = cur.next;
        while(cur.next != this.head){
            if(curNext.data == key){
                cur.next = curNext.next;
                curNext = cur.next;
            }else{
                cur = cur.next;
                curNext = cur.next;
            }

        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
        while(cur != this.head){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        if(this.head.next == this.head){
            System.out.println("没有数据");
        }else {
            while (cur != this.head) {
                System.out.print(cur.data + "  ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
            //删完后。this.head.next == this.head
            while(this.head.next != this.head){
                Node cur = this.head.next;
                this.head.next = cur.next;
                cur = null;
            }
    }
}
