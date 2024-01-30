class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums){
            maxHeap.offer(n);
        }
        for(; k > 1; k--){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}