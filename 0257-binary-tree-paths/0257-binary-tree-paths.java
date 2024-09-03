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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> path = new ArrayList<>();
        backtrack(root, res, path);
        return res;
    }
    private void backtrack(TreeNode node, List<String> res, List<Integer> path){
        path.add(node.val);
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));// 记录最后一个节点
            res.add(sb.toString());// 收集一个路径
            return;
        }
        if(node.left != null){
            backtrack(node.left, res, path);
            path.remove(path.size() - 1);
        }
        if(node.right != null){
            backtrack(node.right, res, path);
            path.remove(path.size() - 1);
        }
    }
}