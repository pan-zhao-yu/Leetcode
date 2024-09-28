class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Create a dp array of size (target + 1)
        int[][] dp = new int[target + 1][nums.length + 1];
        
        // Base case: There's one way to make the amount 0
        for (int j = 0; j <= nums.length; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                // Include the current number nums[j-1] if possible
                if (i >= nums[j - 1]) {
                    // Here, we are using dp[i][j] += dp[i - nums[j-1]][nums.length]
                    dp[i][j] = dp[i][j - 1] + dp[i - nums[j - 1]][nums.length];
                } else {
                    // Exclude the current number if it's larger than the remaining target
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // The answer is the number of ways to form target using all numbers in nums
        return dp[target][nums.length];
    }
}

