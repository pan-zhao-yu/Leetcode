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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfsInorder(root, list);
        return list.get(k - 1);
    }
    private void dfsInorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        dfsInorder(root.left, list);
        list.add(root.val);
        dfsInorder(root.right, list);
    }
}