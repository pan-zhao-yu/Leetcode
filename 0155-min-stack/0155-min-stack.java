class MinStack {

    private Node head;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val, val, null);
        }else{
            head = new Node(val,Math.min(val, head.minValue), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minValue;
    }
    
    private class Node{
        int value;
        int minValue;
        Node next;
        private Node(int value, int minValue, Node next){
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
        
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