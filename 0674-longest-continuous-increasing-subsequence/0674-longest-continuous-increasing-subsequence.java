class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
//dp[i] the longest continues increasing len ending at i
//if(nums[i - 1] > nums[i]) dp[i] = dp[i - 1] + 1;