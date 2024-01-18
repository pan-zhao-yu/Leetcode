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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    
    private boolean dfs(TreeNode node, int tar, int currSum){
        if(node == null) return false;
        
        currSum += node.val;
        if(node.left == null && node.right == null){
            return(currSum == tar);
        }
        return dfs(node.left, tar, currSum) || dfs(node.right, tar, currSum);
    }
}