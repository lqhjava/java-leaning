/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode cur = new ListNode(0);
        ListNode re = cur;
        cur.next = p;
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        while(p != null && p.next != null){
            ListNode pNext = p.next;
            p = pNext.next;
            pNext.next = cur.next;
            cur.next = pNext;
            cur = cur.next.next;
            cur.next = p;
        }
        return re.next;
    }
}
