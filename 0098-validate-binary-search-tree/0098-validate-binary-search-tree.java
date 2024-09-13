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
    Long preVal;

    public boolean isValidBST(TreeNode root) {
        preVal = null; // Initialize preVal to null before starting traversal
        return inOrderT(root);
    }

    public boolean inOrderT(TreeNode node) {
        if (node == null) return true;

        // Traverse the left subtree
        if (!inOrderT(node.left)) return false;

        // Check the current node value
        if (preVal != null && node.val <= preVal) return false;

        // Update preVal to current node's value
        preVal = (long) node.val;

        // Traverse the right subtree
        return inOrderT(node.right);
    }
}
