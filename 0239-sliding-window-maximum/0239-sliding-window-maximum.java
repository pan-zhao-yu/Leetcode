class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int j = 0;
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            if(!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if(i >= k - 1) result[j++] = nums[q.peekFirst()];
        }
        return result;
    }
}