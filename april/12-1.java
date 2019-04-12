/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
            ListNode fast = head;
        ListNode slow =head;
        if(head == null){
            //头节点为空
            return null;
        }else{
            int count = 0;
            while(fast != null){
                count++;
                fast = fast.next;
            }
            if(k<0 || k> count){
               return null;
            }else{
                int i =0;
                while(i < count-k ){
                    i++;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }
}
