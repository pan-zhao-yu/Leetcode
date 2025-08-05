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
        Node nhead = head;
        while(nhead != null){
            Node next = nhead.next;
            nhead.next = new Node(nhead.val);
            nhead.next.next = next;
            nhead = next;
        }
        nhead = head;
        while(nhead != null){
            if(nhead.random != null) nhead.next.random = nhead.random.next;
            nhead = nhead.next.next;
        }
        nhead = head;
        Node res = new Node(0);
        Node temp = res;
        while(nhead != null){
            temp.next = nhead.next;
            temp = temp.next;
            nhead.next = temp.next;
            nhead = nhead.next;
        }
        return res.next;
    }
}