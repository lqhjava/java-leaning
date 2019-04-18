/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null &&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }
        //判断是否为空
        if(fast == null || fast.next == null){
            return null;
        }
        //fast 
        if(fast == head){
            return head;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
