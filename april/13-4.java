/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
            ListNode cur = pHead;
            ListNode prev = new ListNode(0);
            ListNode head = prev;
        if(pHead == null || pHead.next == null){
            return pHead;
        }else{
            while(cur.next != null){
                 ListNode curNext = cur.next;
                if(cur.val == curNext.val){
                    while(curNext != null && curNext.val == cur.val){
                        curNext = curNext.next;
                    }
                    prev.next = curNext;
                    cur = curNext;
                    if(curNext == null){
                        break;
                    }
                    
                    
                }else{
                    prev.next = cur;
                    prev = cur;
                    cur = curNext;
                }
            }
        }
        return head.next;
    }
}
