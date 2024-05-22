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
    private Integer prev;
    private int miniDiff;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        miniDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return miniDiff;
    }
    private void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        if(prev != null){
            miniDiff = Math.min(miniDiff, node.val - prev);
        }
        prev = node.val;
        inorderTraversal(node.right);
    }
}