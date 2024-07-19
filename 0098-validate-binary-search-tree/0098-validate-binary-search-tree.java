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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        //inorder traversal for BSF gives a ordered list, just compare if the previous node is always lower than the current node.  
        if(root == null) return true;
        if(!isValidBST(root.left)){
            return false;
        }
        
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;

        return isValidBST(root.right);
    }
}