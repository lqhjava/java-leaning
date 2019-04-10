package com.lqh.dao;

import com.lqh.impl.IDoubleLinked;

/*
    双向不带头链表
 */
public class TestLinked implements IDoubleLinked {
    //双向链表节点
    class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    //指向尾节点
    private Node last;

    public TestLinked(){
        this.head = null;
        this.last = null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        //第一次插入
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        //第一次插入
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }

    }

    private void isIndexOk(int index){
        //判断index的合法性
        if(index < 0|| index >getLength()){
            throw new NullPointerException("下标不合法");
        }
    }
    private Node findIndex(int index){
        isIndexOk(index);
        Node cur = this.head;
        int count = 0;
        while(count < index-1
        ){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        Node cur = findIndex(index);
        if(index == 0){
            addFirst(data);
            return true;
        }else if(index == getLength()){
            addLast(data);
            return true;
        }else{
            node.next = cur.next;
            node.prev = cur;
            cur.next.prev = node;
            cur.next = node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public int remove(int key) {
            Node cur = this.head;
            while (cur != null) {
                if (cur.data == key) {
                    //3种情况 头 尾 其他
                    if (cur == this.head) {
                        //删除头节点
                        this.head = this.head.next;
                        return key;
                    } else {
                        if (cur.next == null) {
                            //删除尾节点
                            this.last = cur.prev;
                            this.last.next = null;
                            return key;
                        } else {
                            //删除其他节点
                            cur.next.prev = cur.prev;
                            cur.prev.next = cur.next;
                            return key;
                        }
                    }
                }

                cur = cur.next;
            }
            return 0;
    }

    @Override
    public void removeAllKey(int key) {
            Node cur = this.head;
            while (cur != null) {
                if (cur.data == key) {
                    //3种情况 头 尾 其他
                    if (cur == this.head) {
                        //删除头节点
                        this.head = this.head.next;
                    } else {
                        if (cur.next == null) {
                            //删除尾节点
                            this.last = cur.prev;
                            this.last.next = null;
                        } else {
                            //删除其他节点
                            cur.next.prev = cur.prev;
                            cur.prev.next = cur.next;
                        }
                    }
                }

                cur = cur.next;
            }
    }

    @Override
    public int getLength() {
        int count =0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        if(this.head == null){
            System.out.println("没有数据");
        }else {
            while (cur != null){
                System.out.print(cur.data+"  ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        Node cur = this.head;
        while(this.head != null){
            this.head = null;
            cur = cur.next;
            this.head = cur;
        }

    }
}
