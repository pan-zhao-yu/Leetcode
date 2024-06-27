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
public class Solution {
    private String smallestString;

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        smallestString = "~";  // "~" is lexicographically larger than any lower case letter string
        dfs(root, new StringBuilder());
        return smallestString;
    }

    private void dfs(TreeNode node, StringBuilder currentPath) {
        if (node == null) return;

        // Prepend current character to the path (we are building the string from leaf to root)
        currentPath.insert(0, (char) ('a' + node.val));

        // If it's a leaf node, compare and update the smallest string if necessary
        if (node.left == null && node.right == null) {
            String currentString = currentPath.toString();
            if (currentString.compareTo(smallestString) < 0) {
                smallestString = currentString;
            }
        } else {
            // Continue DFS on child nodes
            dfs(node.left, currentPath);
            dfs(node.right, currentPath);
        }

        // Backtrack to explore other paths
        currentPath.deleteCharAt(0);
    }
}