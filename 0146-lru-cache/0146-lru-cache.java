class LRUCache {
    class Node {
        int val, key;
        Node next, prev;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            //remove from list
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            //add front
            head.next.prev = temp;
            temp.next = head.next;
            temp.prev = head;
            head.next = temp;
            return temp.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node nn = new Node(key, value);
        if (map.containsKey(key)) {
            // remove from list and map
            Node t = map.get(key);
            map.remove(key);
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }
        //add front list and map
        map.put(key, nn);
        head.next.prev = nn;
        nn.next = head.next;
        nn.prev = head;
        head.next = nn;
        map.put(key, nn);
        if (map.size() > capacity) {
            //pop last
            Node remove = tail.prev;
            tail.prev = remove.prev;
            remove.prev.next = tail;
            map.remove(remove.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */