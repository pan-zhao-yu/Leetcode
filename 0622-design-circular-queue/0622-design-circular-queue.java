class MyCircularQueue {

    Node head = null;
    Node tail = null;
    int currLen = 0;
    int totalLen = 0;
    
    public MyCircularQueue(int k) {
        totalLen = k;
        head = new Node(-1);
        tail = new Node(-1);
        
        head.next = tail;
        tail.next = head;
        head.prev = tail;
        tail.prev = head;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        Node left = head.prev;
        Node right= head;

        Node temp = new Node(value);

        temp.next= right;

        right.prev = temp;

        left.next=temp;

        temp.prev=left;

        currLen++;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
         Node left = tail;
         Node right= tail.next.next;
 
         left.next = right;

         right.prev = left;


         currLen--;

        return true;
    }
    
    public int Front() {
        if(currLen<=0){
            return -1;
        }

        return tail.next.val;
    }
    
    public int Rear() {
        if(currLen<=0){
            return -1;
        }

        return head.prev.val;
    }
    
    public boolean isEmpty() {
        return currLen == 0 ? true : false;
    }
    
    public boolean isFull() {
        if(currLen == totalLen){
            return true;
        }else{
            return false;
        }
    }
    

}

class Node{
    int val;
    Node next;
    Node prev;
    
    Node(int val){
        this.val = val;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */