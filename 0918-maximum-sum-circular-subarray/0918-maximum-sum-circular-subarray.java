class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSub = nums[0];
        int maxCurr = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxCurr = Math.max(nums[i], maxCurr + nums[i]);
            if(maxCurr > maxSub) maxSub = maxCurr;
        }
        
        int totalSum = 0;
        for(int n : nums){
            totalSum += n;
        }
        
        int minSub = nums[0];
        int minCurr = nums[0];
        for(int i = 1; i < nums.length; i++){
            minCurr = Math.min(nums[i],  minCurr + nums[i]);
            if(minCurr < minSub) minSub = minCurr;
        }
        int wrappingMax = totalSum - minSub;
        if (totalSum == minSub) {
            return maxSub;
        }
        return Math.max(wrappingMax, maxSub);
    }
}