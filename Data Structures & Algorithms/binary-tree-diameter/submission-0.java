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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        getHieght(root);
        return max;
    }

    public int getHieght(TreeNode root){
        if (root == null) return 0;

        int lh = getHieght(root.left);
        int rh = getHieght(root.right);

        max = Math.max(max, lh+rh);

        return (1 + Math.max(lh, rh));
    }
}