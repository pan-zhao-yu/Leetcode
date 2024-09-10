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
    TreeNode pre;
    int count;
    int maxCount;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        pre = null;
        count = 0;
        maxCount = 0;
        dfs(root);
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        if(pre == null || node.val != pre.val) count = 1;
        else{count++;}
        if(count > maxCount){
            res.clear();
            res.add(node.val);
            maxCount = count;
        }else if(count == maxCount){
            res.add(node.val);
        }
        pre = node;
        dfs(node.right);
    }
}