import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestLinkedTree {

    public class Node{
        private char val;
        private Node left;//左孩子
        private Node right;//右孩子
        private int size;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    //根据字符串创建二叉树
     public int  i = 0;//遍历字符串的
    Node createTestTree(String s){
        Node root = null;

        if(s.charAt(i) != '#'){
            root = new Node(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else{
            i++;
        }
        return  root;
    }
    // 结点个数
    int getSize(Node root){
        if(root == null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }
    // 叶子结点个数
    int getLeafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    // 第 k 层结点个数
    int getKLevelSize(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，
    // 如果找到，返回结点，否则返回 null
    //TODO
    Node find(Node root, int value){
        if(root == null || root.val!= value){
            if(find(root.left,value) != null){
                return find(root.left,value);
            }
            if(find(root.right,value) != null){
                return find(root.right,value);
            }
            return null;
        }else{
            return root;
        }
    }
    //二叉树的高度
    int height(Node root){
        if(root == null){
            return 0;
        }
        int re = height(root.left)>height(root.right)?height(root.left):height(root.right);
        return re+1;
    }
    //二叉树的前序遍历   递归  根-》左-》右
    void binaryTreePrevOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+"  ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }
    //二叉树的中序遍历  递归  左-》根-》右
    void binaryTreeInOrder(Node root){
        if(root == null){
            return;
        }

        binaryTreeInOrder(root.left);
        System.out.print(root.val+"  ");
        binaryTreeInOrder(root.right);
    }
    //二叉树的后序遍历  递归  左-》右-》根
    void binaryTreePostOrder(Node root){
        if(root == null){
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val+"  ");
    }

    //二叉树的前序遍历非递归
    void binaryTreePrevOrderNonR(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + "  ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }

    }
    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val+"  ");
            cur = top.right;
        }
    }
    //二叉树的后序遍历非递归
    void binaryTreePostOrderNonR(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;//记录上一个打印的节点
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == prev){
                System.out.print(cur.val+"  ");
                stack.pop();
                prev = cur;//记录上一个打印的节点
                cur = null;
            }else{
                cur = cur.right;
            }

        }
    }

    //二叉树的层序遍历
    void binaryTreeLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        if(cur != null) {
            queue.offer(cur);
        }
        Node top = null;
        while (!queue.isEmpty()){
            top = queue.poll();
            System.out.print(top.val+"  ");
            if(top.left != null){
                queue.offer(top.left);
            }
            if(top.right != null){
                queue.offer(top.right);
            }
        }

    }
    //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    int binaryTreeComplete(Node root) {
       Node cur = root;
       Queue<Node> queue = new LinkedList();
       if(cur != null){
           queue.offer(cur);
       }
       while(!queue.isEmpty()){
           cur = queue.poll();
           if(cur != null) {
               queue.offer(cur.left);
               queue.offer(cur.right);
           }else{
               break;
           }
       }
       while (!queue.isEmpty()){
           if(queue.poll() != null){
               return -1;
           }
       }
        return 0;
    }


}
