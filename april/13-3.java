import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        //比x小的
        ListNode smallS = null;
        ListNode smallE = null;
        //比x大的
        ListNode bigS = null;
        ListNode bigE = null;
        ListNode cur = pHead;
        while(cur != null ){
            //记录cur的下一个节点
            ListNode curNext = cur.next;
            cur.next = null;
            if(cur.val < x){
                if(smallS == null){
                    smallS = cur;
                    smallE = smallS;
                }else{
                    smallE.next = cur;
                    smallE = smallE.next;
                }
            }else{
                if(bigS == null){
                    bigS = cur;
                    bigE = bigS;
                }else{
                    bigE.next = cur;
                    bigE = bigE.next;
                }
            }
            cur = curNext;
        }
        if(smallS == null){
            return bigS;
        }
        smallE.next = bigS;
        return smallS;
    }
}
