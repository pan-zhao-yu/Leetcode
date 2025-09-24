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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = root.val;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        max = Math.max(left + right + node.val, max);
        return Math.max(left, right) + node.val;
    }
}