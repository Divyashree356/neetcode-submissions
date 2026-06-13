/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.

    public void getSerialize(TreeNode root, StringBuilder sb){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode node = q.poll();
                if(node == null) {
                    sb.append("null%");
                    size--;
                    continue;
                }

                sb.append(Integer.toString(node.val));
                sb.append("%");
                q.add(node.left);
                q.add(node.right);
                size--;
            }
        }

    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        getSerialize(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }


    public TreeNode deserializeHelper(String[] data){
        if(data.length == 0 || data[0].equals(null)) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(!q.isEmpty() && i < data.length){
            TreeNode cur = q.poll();

            if(!data[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(data[i]));
                q.add(cur.left);
            }
            i++;

            if(!data[i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(data[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))return null;
        String[] nodeVal = data.split("%");
        // System.out.println(Arrays.toString(nodeVal));
        return deserializeHelper(nodeVal);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));