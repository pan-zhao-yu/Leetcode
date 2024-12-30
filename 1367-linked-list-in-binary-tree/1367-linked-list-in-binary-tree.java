/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // Start DFS from the root of the tree
        if (root == null) return false;
        // Check if the linked list starts from the current node
        if (dfs(root, head)) return true;
        // Otherwise, continue searching in the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode node, ListNode curr) {
        // If we've reached the end of the linked list, return true
        if (curr == null) return true;
        // If the tree node is null or values don't match, return false
        if (node == null || node.val != curr.val) return false;
        // Continue checking the left and right subtrees with the next node in the list
        return dfs(node.left, curr.next) || dfs(node.right, curr.next);
    }
}
