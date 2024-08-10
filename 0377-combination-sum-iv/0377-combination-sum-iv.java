class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[target + 1][n + 1];
        
        // Initialize dp[0][j] = 1 for all j because there's one way to get sum 0 (by choosing nothing)
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp array
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                // Number of ways to form sum i using the first j elements without including nums[j-1]
                dp[i][j] = dp[i][j-1];
                
                // Include the current element nums[j-1] if it fits into the sum
                if (i >= nums[j-1]) {
                    dp[i][j] += dp[i - nums[j-1]][n]; // Use all elements to form remaining sum
                }
            }
        }
        
        return dp[target][n];
    }
}




