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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode curr, int sum){
        if(curr == null){
            return 0;
        }
        int newSum = sum * 10 + curr.val;
        if(curr.left == null && curr.right == null){
            return newSum;
        }
        int leftSum = dfs(curr.left, newSum);
        int rightSum = dfs(curr.right, newSum);
        
        return leftSum + rightSum;
    }
}