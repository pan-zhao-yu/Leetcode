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
        Node head = new Node(0);
        Node curr = root;
        Node tail = head;
        while(curr != null){
            if(curr.left != null){
                tail.next = curr.left;
                tail = tail.next;
            }
            if(curr.right != null){
                tail.next = curr.right;
                tail = tail.next;
            }
            curr = curr.next;
            if(curr == null){
                curr = head.next;
                head.next = null;
                tail = head;
            }
        }
        return root;
    }
}



// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return root;
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 if(queue.peek().left != null) queue.add(queue.peek().left);
//                 if(queue.peek().right != null) queue.add(queue.peek().right);
//                 if(i == size - 1){
//                     queue.poll().next = null;
//                 }else{
//                     queue.poll().next = queue.peek();
//                 }
//             }
//         }
//         return root;
//     }
// }