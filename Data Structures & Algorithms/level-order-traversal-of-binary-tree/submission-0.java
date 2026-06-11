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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return (new ArrayList<>());
        Queue<TreeNode> q = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> sub = new ArrayList<>();

            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                sub.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                size--;
            }
            ans.add(sub);
        }
        return ans;
    }
}