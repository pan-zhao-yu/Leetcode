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
    public int pathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int res = dfs(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        return res + left + right;
    }

    private int dfs(TreeNode node, long target){
        if(node == null) return 0;
        int count = 0;
        if(node.val == target) count++;
        int left = dfs(node.left, target - node.val);
        int right = dfs(node.right, target - node.val);
        return count + left + right;
    }
}
