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
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }
    private int count(TreeNode root, int max){
        int count = 0;
        if(root == null){
            return count;
        }
        if(root.val >= max){
            count = 1;
            max = root.val;
        }
        count += count(root.left, max);
        count += count(root.right, max);
        return count;
    }
}