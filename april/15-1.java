package com.lqh.main;

import com.lqh.dao.ILinkedimpl;
import com.lqh.dao.Queueimpl;

public class Test {
    public ILinkedimpl.Node getNode(ILinkedimpl.Node headA,
                                    ILinkedimpl.Node headB){
        if(headA == null || headB == null){
            return null;
        }
        ILinkedimpl.Node p1 = headA;
        ILinkedimpl.Node p2 = headB;
        int lengthA = 0;
        int lengthB = 0;
        //获取两个链表的长度
        while(p1 != null){
            lengthA++;
            p1 = p1.next;
        }
        while(p2!=null){
            lengthB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        //判断哪个链表长，那个先走
        if(lengthA > lengthB){
            for (int i = 0; i <lengthA-lengthB ; i++) {
                p1 = p1.next;
            }
        }else{
            for (int i = 0; i <lengthB-lengthA ; i++) {
                p2 = p2.next;
            }

        }
        //两个一起走
        while(p1 != null && p2 !=null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == p2 && p1 != null & p2 != null){
            return p1;
        }
        return null;
    }


    public static boolean isValid(String s) {
        char[] k = s.toCharArray();
        int count = 0;
        char[] str = new char[k.length];
        for(int i =0;i<k.length;i++){
            char ch = k[i];
            switch (ch){
                case '(':
                case '[':
                case '{':
                    str[count] = ch;
                    count++;
                    break;
                case ')':
                case '}':
                case ']':

                    if( !(  (str[count]=='(' && ch == ')')
                            || (str[count] =='[' && ch == ']')
                            || (str[count] =='{' && ch == '}'))){
                        return false;
                    }
                    count--;
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "((()))";
        System.out.println(isValid(str));




//        Queueimpl q = new Queueimpl();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        System.out.println(q.empty());
//        System.out.println(q.size());
//        int a = q.poll();
//        System.out.println(a);
//        int b = q.poll();
//        System.out.println(b);



//        ILinkedimpl im1 = new ILinkedimpl();
//        im1.addFirst(30);
//        im1.addFirst(20);
//        im1.addFirst(10);
        //im1.display();
        //ILinkedimpl im2 = new ILinkedimpl();
//        im1.addFirst(90);
//        im1.addFirst(80);
//        im1.addFirst(70);
//        im1.addFirst(10);
//        im1.addFirst(10);
//        im1.display();
//        im1.showNode(im1.rese());
        //im1.partition(50);
        //System.out.println(im1.chkPalindrome());
        //im.remove(6);
        //im.removeAllKey(60);
        //im.clear();
        //im.display();
        //System.out.println(im.getLength());
        //System.out.println(im.contains(10));
        //im.remove(90);
        //im.removeAllKey(10);
        //System.out.println(im.getLength());

    }


}

