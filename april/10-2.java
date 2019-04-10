package com.lqh.main;

import com.lqh.dao.TestLinked;

public class Test {
    public static void main(String[] args) {
        TestLinked im = new TestLinked();
        im.addFirst(10);
        im.addFirst(20);
        im.addFirst(30);
        im.addLast(40);
        im.addLast(50);
        im.addindex(0,10);
        im.addindex(6,60);
        im.addindex(5,50);
        im.display();
        //im.remove(6);
        //im.removeAllKey(60);
        im.clear();
        im.display();
        System.out.println(im.getLength());
        System.out.println(im.contains(10));
        //im.remove(90);
        //im.removeAllKey(10);
        //System.out.println(im.getLength());

    }
}
