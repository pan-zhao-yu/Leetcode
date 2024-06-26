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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true; // Edge case: null tree is trivially an even-odd tree.
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean even = true; // Start at level 0, which is an even level.
        
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if (even) {
                    // Even level: values must be odd and strictly increasing.
                    if (curr.val % 2 == 0 || curr.val <= prev) {
                        return false;
                    }
                } else {
                    // Odd level: values must be even and strictly decreasing.
                    if (curr.val % 2 != 0 || curr.val >= prev) {
                        return false;
                    }
                }
                
                prev = curr.val; // Update prev value for the next comparison.
                
                if (curr.left != null) q.offer(curr.left); // Add left child to queue if it exists.
                if (curr.right != null) q.offer(curr.right); // Add right child to queue if it exists.
            }
            
            even = !even; // Toggle the level parity.
        }
        
        return true; // If all levels are valid, return true.
    }
}