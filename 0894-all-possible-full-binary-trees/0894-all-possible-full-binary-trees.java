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
    Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 1){
            result.add(new TreeNode());
                return result;
        }
        if(n % 2 != 1){
            return result;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        
        for(int leftSize = 1; leftSize < n; leftSize+= 2){
            int rightSize = n - 1 - leftSize;
            List<TreeNode> leftTrees = allPossibleFBT(leftSize);
            List<TreeNode> rightTrees = allPossibleFBT(rightSize);
            for(TreeNode leftTree : leftTrees){
                for(TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode();
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        memo.put(n, result);
        return result;
    }
}