/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node res = map.get(head);
        while(curr != null){
            res.next = map.get(curr.next);
            res.random = map.get(curr.random);
            res = res.next;
            curr = curr.next;
        }
        return map.get(head);
    }
}