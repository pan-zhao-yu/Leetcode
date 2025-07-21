class MinStack {
    class Node{
        int val;
        int min;
        Node next;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    Node head;
    public MinStack() {
        head = new Node();
    }
    
    public void push(int val) {
        Node curr = new Node(val);
        curr.min = head.next == null ? val : Math.min(val, head.next.min);
        curr.next = head.next;
        head.next = curr;
    }
    
    public void pop() {
        if(head.next != null){
            Node curr = head.next;
            head.next = curr.next;
            curr.next = null;
        }
    }
    
    public int top() {
        if(head.next != null){
            return head.next.val;
        }
        return -404;
    }
    
    public int getMin() {
        if(head.next != null){
            return head.next.min;
        }
        return -404;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */