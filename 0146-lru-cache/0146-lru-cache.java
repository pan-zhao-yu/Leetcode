class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void add(int key, int value) {
        Node curr = new Node(key, value);
        Node next = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = next;
        next.prev = curr;
        map.put(key, curr);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node.key, node.value);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            add(key, value);
        } else {
            add(key, value);
            if (map.size() > capacity) {
                remove(tail.prev);
            }
        }
    }
}