class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int n : stones) {
            total += n;
        }
        int target = total / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        
        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return total - dp[stones.length][target] * 2;
    }
}