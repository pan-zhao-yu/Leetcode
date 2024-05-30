class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSub = nums[0];
        int maxCurr = nums[0];
        int totalSum = 0;
        for(int i = 1; i < nums.length; i++){
            maxCurr = Math.max(nums[i], maxCurr + nums[i]);
            maxSub = Math.max(maxSub, maxCurr);
        }
        for(int n : nums){
            totalSum += n;
        }
        int minCurr = nums[0];
        int minSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            minCurr = Math.min(nums[i], minCurr + nums[i]);
            minSum = Math.min(minSum, minCurr);
        }
        int circularMaxSub = totalSum - minSum;
        if(totalSum == minSum) return maxSub;
        return Math.max(circularMaxSub, maxSub);
    }
}