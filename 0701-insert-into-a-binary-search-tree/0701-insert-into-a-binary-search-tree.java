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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        boolean done = true;
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        while(done){
            if(root.val < val){
                if(root.right == null){
                    TreeNode temp = new TreeNode(val);
                    root.right = temp;
                    done = false;
                }else{
                    root = root.right;
                }
            }else{
                if(root.left == null){
                    TreeNode temp = new TreeNode(val);
                    root.left = temp;
                    done = false;
                }else{
                    root = root.left;
                }
            }
        }
        return dummy.left;
    }
    
}