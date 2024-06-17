/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node currHead = root;
        while(currHead.left != null){
            Node currLevel = currHead;
            while(currLevel != null){
                currLevel.left.next = currLevel.right;
                if(currLevel.next != null){
                    currLevel.right.next = currLevel.next.left;
                }
                currLevel = currLevel.next;
            }
            currHead = currHead.left;
        }
        return root;
    }
}