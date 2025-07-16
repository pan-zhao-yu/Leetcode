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
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }
    private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> im){
        if(ps > pe || is > ie) return null;
        TreeNode curr = new TreeNode(pre[ps]);
        int index = im.get(pre[ps]);
        int leftsize = index - is;
        curr.left = build(pre, ps + 1, ps + leftsize, in, is, index - 1, im);
        curr.right = build(pre, ps + leftsize + 1, pe, in, index + 1, ie, im);
        return curr;
    }
}