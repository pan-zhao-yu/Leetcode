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
    
    private int result = Integer.MAX_VALUE;
    private TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        
        dfs(node.left);
        if(prev != null){
            result = Math.min(result, node.val - prev.val);
        }
        prev = node;
        dfs(node.right);
    }
    
}