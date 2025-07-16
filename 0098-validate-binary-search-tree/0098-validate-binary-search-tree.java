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
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node){
        boolean l = true, r = true;
        if(node.left != null) l = inorder(node.left);
        if(prev != null && prev >= node.val) return false;
        prev = node.val;
        if(node.right != null) r = inorder(node.right);
        return l && r;         
    }
}