package com.lqh.main;
import com.lqh.dao.IDoubleLinkedimpl;
public class Test {
    public static void main(String[] args) throws InterruptedException {
        IDoubleLinkedimpl im = new IDoubleLinkedimpl();
        im.display();
        im.addFirst(20);
        //System.out.println(im.getLength());
        //im.addFirst(20);
        //im.addFirst(30);
        //im.addLast(20);
        //im.addLast(20);
        //im.addLast(30);
        //im.addindex(2,20);
        //im.addindex(2,30);
        //im.addindex(6,20);
        im.display();
        System.out.println("------------------------");
        //im.clear();
        //im.removeAllKey(30);
        //im.display();
        //Thread.sleep(1000);
        //System.out.println("dasdasd");
    }
}
