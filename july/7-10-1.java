class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        int temp = 0;
        int count = 0;
        while(p != null){
            p = p.next;
            count++;
        }
        p = head;
       while(p != null){
           ListNode q = p;
           if(count <=0){
               break;
           }
        for(int i =1; i <count; i++){
            q = q.next;
        }
           temp  = q.val;
           q.val = p.val;
           p.val = temp;
           p = p.next;
           count=count-2;
       }
        return head;
    }
}
