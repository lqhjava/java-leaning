/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
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
        //判断哪个链表长
        if(lengthA > lengthB){
            for (int i = 0; i <lengthA-lengthB ; i++) {
                p1 = p1.next;
            }
        }else{
            for (int i = 0; i <lengthB-lengthA ; i++) {
                p2 = p2.next;
            }

        }
        while(p1 != null && p2 !=null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == p2 && p1 != null & p2 != null){
            return p1;
        }
        return null;
    }
}
