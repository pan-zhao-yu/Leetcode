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
    private long prevVal = Long.MIN_VALUE; // Use Long.MIN_VALUE to handle all cases

    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root);
    }

    private boolean inOrderTraversal(TreeNode node) {
        if (node == null) return true;

        // Check left subtree
        if (!inOrderTraversal(node.left)) return false;

        // Current node's value must be greater than the previous node's value in in-order traversal
        if (node.val <= prevVal) return false;
        
        // Update the previous value to the current node's value
        prevVal = node.val;

        // Check right subtree
        return inOrderTraversal(node.right);
    }
}
