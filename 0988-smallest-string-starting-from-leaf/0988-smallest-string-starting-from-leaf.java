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
    String smallest;
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        smallest = "~";
        dfs(root, new StringBuilder());
        return smallest;
    }
    private void dfs(TreeNode node, StringBuilder curr){
        if(node == null) return;
        curr.insert(0, (char)('a' + node.val));
        if(node.left == null && node.right == null){
            String currString = curr.toString();
            if(currString.compareTo(smallest) < 0){
                smallest = currString;
            }
        }else{
            dfs(node.left, curr);
            dfs(node.right, curr);
        }
        curr.deleteCharAt(0);
    }
}