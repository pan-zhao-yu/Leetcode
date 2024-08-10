class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        
        dp[0] = 1;  // There's one way to make sum 0, by choosing nothing
        
        // Iterate over every possible target sum
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];  // Add the number of ways to make sum (j - num)
                }
            }
        }
        
        return dp[target];
    }
}



