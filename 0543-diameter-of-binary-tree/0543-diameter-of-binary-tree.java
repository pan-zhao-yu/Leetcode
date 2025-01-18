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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int left = dfs(root.left, 0);
        int right = dfs(root.right, 0);
        return Math.max(res, left + right);
    }

    private int dfs(TreeNode node, int count){
        if(node == null) return 0;
        int left = dfs(node.left, count);
        int right = dfs(node.right, count);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}