/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode prev = null;
    public void ConvertChild(TreeNode p){
        if(p == null){
            return ;
        }
        ConvertChild(p.left);
        //
        p.left = prev;
        if(prev != null){
        prev.right = p;
        }
        prev = p;
        ConvertChild(p.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }
}
