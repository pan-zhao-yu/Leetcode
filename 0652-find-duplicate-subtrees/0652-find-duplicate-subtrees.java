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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> count = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        dfs(root, count, result);
        return result;
    }
    
    private String dfs(TreeNode node, Map<String, Integer> count, List<TreeNode> result){
            if(node == null){
                return "N";
            }
            
            String subTree = node.val + "," 
                + dfs(node.left, count, result) + "," 
                + dfs(node.right, count, result);
            
            count.put(subTree, count.getOrDefault(subTree, 0) +1);
            if(count.get(subTree) == 2){
                result.add(node);
            }
            
            return subTree;
        }
}