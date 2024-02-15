class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,  b) -> b - a);
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek()) / 2.0;
        }else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


// class MedianFinder {
//     List<Integer> nums;
//     public MedianFinder() {
//         nums = new ArrayList();
        
//     }
    
//     public void addNum(int num) {
//         nums.add(num);
//         Collections.sort(nums);
//     }
    
//     public double findMedian() {
//         if(nums.size() % 2 == 0){
//             return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1) ) / 2.0;
//         }
//         return nums.get(nums.size() /2);
//     }
// }
