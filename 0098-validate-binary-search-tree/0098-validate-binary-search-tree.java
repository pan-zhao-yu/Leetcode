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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node){
        boolean left = true, right = true;
        if(node.left != null) left = inOrder(node.left);
        if( prev != null && node.val <= prev) return false;
        prev = node.val;
        if(node.right != null) right = inOrder(node.right);
        return left && right;
    }
}