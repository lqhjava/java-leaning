package com.lqh.main;

public class Test1 {
    private static Test1 test1;
    private Test1(){}
    public static Test1 getTest1(){
        if(test1 == null){
            synchronized (Test1.class){
                if(test1 == null){
                    //线程1在这里还没有执行完成 但是test1已经不是null
                    //但是也没有初始化完成  那么线程2 进入这个方法
                    //会直接返回一个可能没有初始化完的test1
                    test1 = new Test1();
                }
            }

        }
        return test1;
    }

    public static void main(String[] args) {

    }
}
