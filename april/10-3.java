/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }else{
            ListNode cur = head;
            ListNode curNext = cur.next;
            while(cur.next != null){
            if(curNext.val == val){
                cur.next = curNext.next;
                curNext = cur.next;
            }else{
                cur = cur.next;
                curNext = cur.next;
            }
        }
        if(head.val == val){
            head = head.next;
            }
        }
        return head;
   }
}
