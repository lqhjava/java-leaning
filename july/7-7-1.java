class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        
        ListNode q = l2;
        //创建一个链表头
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(p.next != null && q.next != null){
          ListNode pNext = p.next;
            if(p.val < q.val){
                cur.next = p;
                p = p.next;
            }else{
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        if(p.next == null){
            cur.next = q;
        }
        if(q.next ==null){
            cur.next = p;
        }
        return head.next;
    }
}
