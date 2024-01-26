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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == null && root2 == null;
        }
        if(root1.val != root2.val) return false;
        
        //boolean notFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
       // boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        if(flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) == true || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left) == true){
            return true;
        }else{
            return false;
        }
    }
}