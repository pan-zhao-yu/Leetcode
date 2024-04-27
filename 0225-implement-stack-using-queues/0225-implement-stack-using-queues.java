class MyStack {
    private Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i = 1; i < queue.size(); i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/** Two pointer approach*/
// class MyStack {
//     private Queue<Integer> queue1;
//     private Queue<Integer> queue2;
//     int top;
//     public MyStack() {
//         queue1 = new LinkedList<>();
//         queue2 = new LinkedList<>();
//         top = -1;
//     }
    
//     public void push(int x) {
//         queue2.offer(x);
//         while(!queue1.isEmpty()){
//             queue2.offer(queue1.poll());
//         }
//         Queue<Integer> temp = queue1;
//         queue1 = queue2;
//         queue2 = temp;
//         top = queue1.peek();
//     }
    
//     public int pop() {
//         if(queue1.isEmpty()) return -1;
//         int popped = queue1.poll();
//         if(!queue1.isEmpty()){
//             top = queue1.peek();
//         }else{
//             top = -1;
//         }
//         return popped;
        
//     }
    
//     public int top() {
//         return top;
//     }
    
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }