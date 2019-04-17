public boolean chkPalindrome(){
        //判断回文
        //只遍历一遍
        if(this.head == null){
            return false;
        }else if(this.head.next == null){
            return true;
        }else {
            Node fast = this.head;
            Node slow = this.head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //逆置slow之后的链表
            Node p = slow.next;
            Node p1 = p.next;
            while (p != null) {
                p.next = slow;
                slow = p;
                p = p1;
                if (p1 != null) {
                    p1 = p1.next;
                }
            }
            //逆置之后进行判断
            //此时slow 指向链表尾节点 fast指向null
            Node cur = this.head;
            while (cur != slow) {
                if (cur.data != slow.data) {
                    return false;
                }
                if (cur.next == slow) {
                    //偶数情况下
                    return true;
                }
                cur = cur.next;
                slow = slow.next;

            }
        }
        return true;
    }
