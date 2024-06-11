class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for(int i = nums.length -1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}