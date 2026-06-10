/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null && q != null) return false;
        else if (q == null && p != null) return false;

        if( p.val != q.val) return false;
        else{
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return (left && right);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if (isSameTree(root, subRoot)) return true;
        boolean op1 = isSubtree(root.left, subRoot);
        boolean op2 = isSubtree(root.right, subRoot);

        if(op1 == true || op2 == true) return true;
        else return false;

    }
}