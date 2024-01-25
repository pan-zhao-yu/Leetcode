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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int robCurr =  node.val + left[1] + right[1];
        int skipCurr = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{robCurr, skipCurr};
    }
}