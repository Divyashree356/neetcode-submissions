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
    int maxSum = Integer.MIN_VALUE;
    public int getSum(TreeNode root) {
        if(root == null)return 0;

        int lsum = getSum(root.left);
        int rsum = getSum(root.right);

        int left = Math.max(0, lsum);
        int right = Math.max(0, rsum);

        int total = left + right + root.val;
        maxSum = Math.max(maxSum, total);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        getSum(root);
        return maxSum;

    }
}