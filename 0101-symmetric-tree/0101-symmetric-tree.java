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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode lTree, TreeNode rTree){
        if(lTree == null && rTree == null){
            return true;
        }
        if(lTree == null || rTree == null){
            return false;
        }
        if(lTree.val != rTree.val){
            return false;
        }
        boolean leftTree = dfs(lTree.left, rTree.right);
        boolean rightTree = dfs(lTree.right, rTree.left);
        
        return leftTree && rightTree;

    }
}