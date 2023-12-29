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

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Creating a copy of each node and interweaving
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Updating random pointers of the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separating the original and the copied lists
        Node dummy = new Node(0);
        Node copyCurrent = dummy, originalCurrent = head;
        while (originalCurrent != null) {
            copyCurrent.next = originalCurrent.next;
            originalCurrent.next = originalCurrent.next.next;
            copyCurrent = copyCurrent.next;
            originalCurrent = originalCurrent.next;
        }

        return dummy.next;
    }
}
