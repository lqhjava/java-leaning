/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
       
        ListNode cur = new ListNode(0);
        cur.next = head;
            ListNode fast = cur;
        ListNode slow = cur;
        int count = 0;
        
        while(count < n){
            fast = fast.next;
            count++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return cur.next;
    }
}
