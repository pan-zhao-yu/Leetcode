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
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                builder.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                builder.append("null,");
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        Queue<TreeNode> tree = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        tree.add(root);
        
        while (!nodes.isEmpty()) {
            TreeNode parent = tree.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            
            if (!left.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                parent.left = leftNode;
                tree.add(leftNode);
            }
            if (!right.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                parent.right = rightNode;
                tree.add(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));