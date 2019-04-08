package com.lqh.main;

import com.lqh.dao.TestLinked;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TestLinked im = new TestLinked();
        im.add(0,60);
        im.add(0,20);
        im.add(0,10);
        im.add(0,30);
        im.add(0,40);
        im.add(0,50);
        im.display();
        System.out.println("------------------------");
        im.remove(60);
        im.display();
        int i = im.search(10);
        if(i >= 0){
            System.out.println(i+"包含");
        }
        boolean j = im.contains(50);
        if(j){
            System.out.println(j+"包含");
        }
        Object z = im.getPos(5);
        System.out.println(z);
        //System.out.println(im.size());
        //im.display();
        System.out.println("------------------------");
        im.clear();
        im.display();

    }
}
