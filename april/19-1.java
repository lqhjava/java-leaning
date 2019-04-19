/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //进位
        int c = 0;
        int sum = 0;
        while(p != null && q != null){
            sum = q.val + p.val;
            //c = sum /10;
            cur.next = new ListNode(0);
            cur = cur.next;
            cur.val = (sum +c) %10;
            c = (sum +c)/10;
            p = p.next;
            q = q.next;
        }
        if(p == null && q == null){
            if(c > 0){
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = c;
                return head.next;
            }else{
                cur = null;
                return head.next;
            }
        }
        if(p == null && q != null){
            while(q != null){
            cur.next = new ListNode(0);
            cur = cur.next;
            cur.val = (q.val+ c)%10;
            c =  (q.val+ c) /10;
            q = q.next;
            }
            if(c > 0){
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = c;
                return head.next;
            }else{
                cur = null;
                return head.next;
            }
        }
        if(q == null && p != null){
            while(p != null){
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = (p.val+ c)%10;
                c =  (p.val+ c) /10;
                p = p.next;
            }
            if(c > 0){
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = c;
                return head.next;
            }else{
                cur = null;
                return head.next;
            }
        }
        return null;
    }
}
