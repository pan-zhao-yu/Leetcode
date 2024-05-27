class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            if(minHeap.size() < k){
                minHeap.offer(n);
            }else{
                minHeap.offer(n);
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}



// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for(int n : nums){
//             minHeap.offer(n);
//             if(minHeap.size() > k){
//                 minHeap.poll();
//             }
//         }
//         return minHeap.peek();
//     }
// }