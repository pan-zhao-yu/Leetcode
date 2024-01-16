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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        
        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.val);
    }
}