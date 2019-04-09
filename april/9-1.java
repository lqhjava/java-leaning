package com.lqh.main;

import com.lqh.dao.TestLinked;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TestLinked im = new TestLinked();
        im.addFirst(10);
        im.addFirst(10);
        im.addFirst(10);
        im.addLast(10);
        im.addLast(10);
        //im.display();
        im.addindex(2,10);
        im.addindex(1,10);
        im.addindex(7,10);
        im.display();
        //System.out.println(im.getLength());
        //System.out.println(im.contains(0));
        //im.remove(90);
        //im.removeAllKey(10);
        im.clear();
        im.display();
        //System.out.println(im.getLength());

    }
}
