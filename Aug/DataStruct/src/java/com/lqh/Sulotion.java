package java.com.lqh;


public class Sulotion {


    //有序链表合二为一
    public Node merge(Node head1,Node head2){
        //新的链表
        Node newHead = new Node(0);
        Node newCur = newHead;
        //遍历head1
        Node cur1 = head1;
        //遍历head2
        Node cur2 = head2;
        while (cur1 != null && cur2!= null){
            if(cur1.value < cur2.value){
                newCur = cur1;
                cur1 = cur1.next;
            }else {
                newCur = cur2;
                cur2 = cur2.next;
            }
            newCur = newCur.next;
        }
        if(cur1 != null){
            newCur.next = cur1;
        }
        if(cur2 != null){
            newCur.next = cur2;
        }
        return newHead.next;
    }

    //复制简单链表
    public Node copy(Node head){
        if(head == null ){
            return head;
        }
        Node cur = head.next;

        Node newHead = new Node(head.value);
        Node newLast = newHead;

        while(cur != null){
            Node node = new Node(cur.value);
            newLast.next = node;
            newLast = newLast.next;
            cur = cur.next;
        }
        return newHead;
    }

    //复制复杂链表
    public CNode copy(CNode head){
        if(head == null){
            return null;
        }
        CNode cur = head;

        //复制节点
        while (cur != null){
            CNode newNode = new CNode(cur.value);

            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        CNode oldNode = head;
        CNode newNode = oldNode.next;

        //复制redom
        while (newNode.next != null){
            newNode.redom = oldNode.redom.next;
            oldNode = newNode.next;
            newNode = oldNode.next;
        }
        CNode oldCur = head;
        CNode newHead =oldCur.next;

        //回复
        while (oldCur != null){
            CNode newCur = oldNode.next;
            oldCur.next = newCur.next;
            if(newCur.next != null) {
                newCur.next = newCur.next.next;
            }
            oldCur = oldNode.next;
        }
        return newHead;
    }


}
