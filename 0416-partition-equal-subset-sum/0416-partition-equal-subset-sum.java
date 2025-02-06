class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= target; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target] == target;
    }
}