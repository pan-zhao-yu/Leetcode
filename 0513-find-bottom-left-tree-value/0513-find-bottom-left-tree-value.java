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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = root.val;
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            ans = curr.val;
            
            if(curr.right != null){
                q.offer(curr.right);
            }
            if(curr.left != null){
                q.offer(curr.left);
            }
        }
        return ans;
    }
}