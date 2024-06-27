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
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean even = true;
        while(!q.isEmpty()){
            int size = q.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(even){
                    if(curr.val % 2 == 0 || curr.val <= prev) return false;
                }else{
                    if(curr.val % 2 == 1 || curr.val >= prev) return false;
                }
                prev = curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            even = !even;
        }
        return true;
    }
}