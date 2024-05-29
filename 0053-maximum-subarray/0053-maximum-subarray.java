class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int maxCurr = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxCurr = Math.max(nums[i], maxCurr + nums[i]);
            if(maxCurr > maxSub) maxSub = maxCurr;
        }
        return maxSub;
    }
}