class LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            addFront(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node toAdd = new Node(key, value);
        addFront(toAdd);
        map.put(key, toAdd);
        if(map.size() > capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
        }
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addFront(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */