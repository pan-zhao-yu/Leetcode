class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(long n : nums){
            minHeap.add(n);
        }

        int res = 0;
        while(minHeap.peek() < k && minHeap.size() >= 2){
            long num1 = minHeap.poll();
            long num2 = minHeap.poll();
            long newNum = Math.min(num1, num2) * 2 + Math.max(num1, num2);
            minHeap.add(newNum);
            res++;
        }
        return res;
    }
}