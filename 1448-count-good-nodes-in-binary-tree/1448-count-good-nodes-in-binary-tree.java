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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max);
    }
    
    private int dfs(TreeNode node, Integer max){
        if(node == null) return 0;
        int count = 0;
        if(node.val >= max){
            count = 1;
            max = node.val;
        }
        count += dfs(node.left, max);
        count += dfs(node.right, max);
        return count;
    }
}