class MyLinkedList {

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;  // Dummy head
    private int size;

    public MyLinkedList() {
        head = new Node(0);  // Initialize with a dummy head
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;  // Index out of bounds
        }
        Node curr = head.next;  // Start with the first real node
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);  // Reuse addAtIndex for simplicity
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);  // Add at the end of the list
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;  // Index out of bounds for insertion
        }
        Node prev = head;  // Start with the dummy head
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;  // Index out of bounds for deletion
        }
        Node prev = head;  // Start with the dummy head
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;  // Bypass the node to delete
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */