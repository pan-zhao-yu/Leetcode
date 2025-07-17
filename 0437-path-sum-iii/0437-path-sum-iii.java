class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return (int) dfs(root, (long) targetSum);
    }

    private long dfs(TreeNode node, long targetSum) {
        if (node == null) return 0;
        long count = countPaths(node, targetSum);
        count += dfs(node.left, targetSum);
        count += dfs(node.right, targetSum);
        return count;
    }

    private long countPaths(TreeNode node, long targetSum) {
        if (node == null) return 0;
        long curr = 0;
        if ((long) node.val == targetSum) curr++;
        curr += countPaths(node.left, targetSum - node.val);
        curr += countPaths(node.right, targetSum - node.val);
        return curr;
    }
}
