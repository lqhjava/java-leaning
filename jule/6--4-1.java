package com.lqh.main;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThredS implements Runnable{

    private int titile = 20;
    private Lock titileLock = new ReentrantLock();
    @Override
    public void run() {
        while(titile > 0) {
            try {
                //对titile上锁
                titileLock.lock();
                if (this.titile > 0) {
                    System.out.println("这是" + Thread.currentThread().getName() + "买第" + this.titile-- + "张票");
                }
            } finally {
                //释放锁
                titileLock.unlock();
            }
        }


    }
    private  synchronized void sellPrint(){
        if(this.titile > 0){
            System.out.println("这是" + Thread.currentThread().getName() + "买第" + this.titile-- + "张票");
        }
    }



}

public class TestDemo2 {

    public static void main(String[] args) {
        MyThredS my = new MyThredS();
        Thread th1 = new Thread(my);
        Thread th2 = new Thread(my);
        Thread th3 = new Thread(my);

        th1.start();
        th2.start();
        th3.start();
    }

}
