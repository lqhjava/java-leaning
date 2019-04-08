package com.lqh.dao;

import com.lqh.ISequence;

import java.util.Arrays;

/*
    单向顺序表
 */
public class TestLinked implements ISequence {
    //创建一个数组用来存储数据
    private Object[] data;
    //计录数组内数据的个数
    private int useside;
    //定义数组的初始长度
    private static final int LENGTH = 10;

    public TestLinked(){
        this.data = new Object[LENGTH];
        this.useside = 0;
    }
    //判断数据是否存满
    private boolean isFulll(){
        if(this.useside == data.length){
            return true;
        }
        return false;
    }

    @Override
    //插入数据
    public boolean add(int pos, Object data) {
        //判断pos的合法性
        if(pos < 0||pos >this.useside){
            throw new NullPointerException("下表不合法");
        }
        //如果插入数据，数据超过数组长度，对数组进行扩容
        if(isFulll()){
            this.data = Arrays.copyOf(this.data,
                    this.data.length+1);
        }
        //插入数据
          //先移数据
        for (int i = this.useside-1; i >= pos ; i--) {
            this.data[i+1] = this.data[i];
        }
        //添加数据
        this.data[pos] = data;
        this.useside++;
        return false;
    }

    private boolean isEmpty(){
        return this.useside == 0;
    }
    @Override
    //查找key是否存在，存在，返回下标
    public int search(Object key) {
        //判断数组里是否有数据
        if(isEmpty()){
            return -1;
        }
        //判断key的合法性
        if(key == null){
            throw new UnsupportedOperationException("不可以传入null");
        }
        //查找
        for (int i = 0; i < this.useside; i++) {
            if(this.data[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        //判断数组里是否有数据
        if(isEmpty()){
            return false;
        }
        //判断key的合法性
        if(key == null){
            throw new UnsupportedOperationException("不可以传入null");
        }
        //查找
        for (int i = 0; i < this.useside; i++) {
            if(this.data[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        //判断pos的合法性
        if(pos < 0|| pos >this.useside){
            throw new NullPointerException("pos不合法");
        }
        return this.data[pos];
    }

    @Override
    public Object remove(Object key) {
        //判断key的合法性
        if(key == null){
            throw new NullPointerException("pos不合法");
        }
        if( isEmpty()){
            return null;
        }
            Object oldData = key;
            int i = search(key);
            for ( i = search(key); i < this.useside; i++) {
                this.data[i] = this.data[i+1];
            }
            //删除后，最后一位还有值,数据减少
        this.data[i+1] = null;
        this.useside--;
        return true;
    }

    @Override
    public int size() {
        return this.useside;
    }

    @Override
    public void display() {
        if(this.useside == 0){
            System.out.println("没有数据");
        }else{
            for (int i = 0; i < this.useside; i++) {
                System.out.print(this.data[i]+"   ");
            }
            System.out.println();
        }

    }

    @Override
    public void clear() {
        for (int i = 0; i < this.useside; i++) {
            this.data[i] = null;
        }
        this.useside = 0;
    }
}
