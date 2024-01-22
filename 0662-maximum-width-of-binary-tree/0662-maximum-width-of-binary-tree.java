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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int result = 0;
        Queue<NodePosition> queue = new LinkedList<>();
        queue.offer(new NodePosition(root, 1));
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int levelStart = queue.peek().position;
            
            for(int i = 0; i < levelSize; i++){
                NodePosition currNode = queue.poll();
                int currPosition = currNode.position;
                result = Math.max(result, currPosition - levelStart +1);
                
                if(currNode.node.left != null){
                    queue.offer(new NodePosition(currNode.node.left, currPosition *2));
                }
                if(currNode.node.right != null){
                    queue.offer(new NodePosition(currNode.node.right, currPosition *2 +1));
                }
            } 
        }
        return result;
    }
    
    
}
public class NodePosition {
    int position;
    TreeNode node;
    
    NodePosition(TreeNode node, int position){
        this.node = node;
        this.position = position;
    }
}