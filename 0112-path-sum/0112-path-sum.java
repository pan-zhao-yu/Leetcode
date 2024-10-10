class Solution {
    boolean fund = false;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Reset fund to false in case this is a re-used Solution instance
        fund = false;
        backtrack(root, targetSum, 0);
        return fund;
    }
    
    private void backtrack(TreeNode node, int target, int sum) {
        if (node == null) return;
        
        // Update the current sum
        sum += node.val;
        
        // Check if we've reached a leaf node and the sum matches the target
        if (node.left == null && node.right == null && sum == target) {
            fund = true;
            return;
        }
        
        // Recursively search in the left and right subtree
        backtrack(node.left, target, sum);
        backtrack(node.right, target, sum);
    }
}
