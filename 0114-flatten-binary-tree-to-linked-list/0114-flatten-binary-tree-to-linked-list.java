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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // Recursively flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);
        
        // Store the left and right subtrees
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;
        
        // Make the left subtree the right subtree
        root.left = null;
        root.right = leftSubtree;
        
        // Find the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Attach the original right subtree to the end of the new right subtree
        current.right = rightSubtree;
    }
}
