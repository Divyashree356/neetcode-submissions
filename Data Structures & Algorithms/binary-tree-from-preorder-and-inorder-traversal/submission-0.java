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
    int preIdx = 0;

    public TreeNode getTree(int[] preorder, int start, int end, HashMap<Integer, Integer> hm){
        if(start > end)return null;

        int rootval = preorder[preIdx++];
        TreeNode root = new TreeNode(rootval);
        
        int rootValIdx = hm.get(rootval);
        root.left = getTree(preorder, start, rootValIdx-1, hm);
        root.right = getTree(preorder, rootValIdx+1, end, hm);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }

        return getTree(preorder, 0, inorder.length-1, hm);
    }
}