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
    Long prev;

    public boolean isValidBST(TreeNode root) {
        prev = null; // Initialize preVal to null before starting traversal
        return inOrder(root);
    }

    public boolean inOrder(TreeNode node) {
        boolean left = true, right = true;
        if(node.left != null) left = inOrder(node.left);
        if(prev != null && prev >= (long)node.val) return false;
        prev = (long)node.val;
        if(node.right != null) right = inOrder(node.right);

        
        return right && left;
    }
}
