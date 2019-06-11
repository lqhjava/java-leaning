import java.util.*;


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null){
            return null;
        }
        ListNode cur  = pHead;
        //int count = 0;
        //小于x
        ListNode smallS = new ListNode(0);
        ListNode smallH = smallS;

        //大于x
        ListNode bigS = new ListNode(0);
        ListNode bigH = bigS;

        while(cur.next != null){
            if(cur.val < x){

                smallS.next = cur;
                smallS  = smallS .next;

            }else if(cur.val >= x){
                bigS.next = cur;
                bigS  = bigS.next;
            }

            cur = cur.next;
        }

        if(smallS.next == null){
            smallS.next =bigS.next;
        }
        smallS.next = bigH.next;
        bigS.next = null;
        return smallH.next;
    }
}
