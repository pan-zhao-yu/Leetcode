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
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        backtrack(root, targetSum, 0);
        return res;
    }
    private void backtrack(TreeNode node, int target, int curr){
        if(node == null) return;
        curr += node.val;
        if(curr == target && node.left == null && node.right == null){
            res = true;
            return;
        }
        backtrack(node.left, target, curr);
        backtrack(node.right, target, curr);
        curr -= node.val;
    }
}