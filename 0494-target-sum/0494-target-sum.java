class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }
        
        int left = (sum + target) / 2;
        int[][] dp = new int[nums.length + 1][left + 1];
        
        // Initialize base case: There's one way to get sum 0, which is by choosing no elements.
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= left; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][left];
    }
}
