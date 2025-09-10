class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node(int val, Node prev, Node next){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    int capa;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capa = capacity;
        map = new HashMap<>();
        tail = new Node(0);
        head = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        if(map.containsKey(key)){
            Node curr = map.get(key);
            res = curr.val;
            remove(curr);
            add(curr);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node toAdd = new Node(key, value);
        add(toAdd);
        if(map.size() > capa){
            remove(map.get(tail.prev.key));
        }
    }

    private void add(Node n){
        n.next = head.next;
        head.next = n;
        n.prev = head;
        n.next.prev = n;
        map.put(n.key, n);
    }

    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        map.remove(n.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */