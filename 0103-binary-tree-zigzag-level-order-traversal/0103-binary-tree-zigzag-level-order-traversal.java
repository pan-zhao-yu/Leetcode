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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        boolean reverse = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(reverse){
                    curr.add(0, temp.val);
                }else{
                    curr.add(temp.val);
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            result.add(new ArrayList(curr));
            reverse = !reverse;
        }
        return result;
    }
}