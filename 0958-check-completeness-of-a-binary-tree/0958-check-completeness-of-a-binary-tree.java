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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                leaf = true;
            }else{
                if(leaf){
                    return false;
                }
                queue.offer(curr.left);
                queue.offer(curr.right);
            } 
        }
        return true;
    }
}