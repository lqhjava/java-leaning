package com.lqh.dao;

import com.lqh.impl.ICLinked;

public class ICLinkedimpl implements ICLinked {
    class Node {
        int data;
        Node next;

        public Node(){
            this.data = -1;
        }
        public Node(int data){
            this.data = data;
        }
    }
    private Node head;
    public ICLinkedimpl(){
        this.head = new Node();
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
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next != this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;

    }
    private void isIndexOk(int index){
        if(index < 0 || index >getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }

    }
    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = this.head;
        isIndexOk(index);
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
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
        while(cur.next !=this.head){
            if(cur.next.data == key){
                return cur;
            }
            cur= cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node cur = findKeyBefore(key);
        int oldData =0;
        if(cur == null){
            throw new UnsupportedOperationException("key不存在");
        }else{
            oldData = cur.next.data;
            cur.next = cur.next.next;
        }

        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        Node curNext = cur.next;
        while(cur.next !=this.head){
            if(curNext.data == key){
                cur.next = curNext.next;
                curNext = cur.next;
            }else {
                cur = cur.next;
                curNext = cur.next;
            }
        }

    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while(cur.next != this.head){
            cur= cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur != this.head){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {

        while(this.head.next != this.head){
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.next = null;
        }

    }
}
