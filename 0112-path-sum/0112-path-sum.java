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
        if(root == null) return false;
        return pathSum(root, targetSum);
    }
    private boolean pathSum(TreeNode node, int target){
        if(target == node.val && node.left == null && node.right == null){
            return true;
        }
        if(node.left == null && node.right == null) return false;
        if(node.left != null){
            if(pathSum(node.left, target - node.val)) return true;
        }
        if(node.right != null){
            if(pathSum(node.right, target - node.val)) return true;
        }
        return false;
    }
}