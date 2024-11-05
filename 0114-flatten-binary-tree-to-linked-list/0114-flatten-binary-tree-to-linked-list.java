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
        if(root == null) return;
        //post-order traversal to flatten the left and right subtree then connect
        flatten(root.left);
        flatten(root.right);
        TreeNode leftSub = root.left;
        TreeNode rightSub = root.right;
        root.right = leftSub;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = rightSub;
    }
}