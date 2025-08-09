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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //if (preorder == null || inorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        return build(inMap, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1); 
    }
    private TreeNode build(Map<Integer, Integer> inMap, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int inPosition = inMap.get(val);
        int leftSize = inPosition - inStart;
        root.left = build(inMap, preorder, inorder, preStart + 1, preStart + leftSize, inStart, inPosition - 1);
        root.right = build(inMap, preorder, inorder, preStart + leftSize + 1, preEnd, inPosition + 1, inEnd);
        return root;
    }
}