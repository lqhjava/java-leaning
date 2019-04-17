public Node findCyle(){
        //找到入环的节点
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next ==null){
            return null;
        }
        slow = this.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
