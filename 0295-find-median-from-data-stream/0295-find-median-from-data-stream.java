class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a); //(Collection.revereseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if((minHeap.size() + maxHeap.size()) % 2 == 0) return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */