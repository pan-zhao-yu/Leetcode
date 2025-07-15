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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        while(!q.isEmpty()){
            List<Integer> row = new ArrayList();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.pollLast();
                row.add(curr.val);
                if(curr.left != null) q.addFirst(curr.left);
                if(curr.right != null) q.addFirst(curr.right);
            }
            res.add(row);
        }
        return res;
    }
}