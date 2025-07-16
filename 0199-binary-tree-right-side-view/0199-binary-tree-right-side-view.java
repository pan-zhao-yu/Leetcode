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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        while(!q.isEmpty()){
            int size = q.size();
            res.add(q.peekLast().val);
            for(int i = 0; i < size; i++){
                TreeNode curr = q.pollLast();
                if(curr.right != null) q.addFirst(curr.right);
                if(curr.left != null) q.addFirst(curr.left);
            }
        }
        return res;
    }
}