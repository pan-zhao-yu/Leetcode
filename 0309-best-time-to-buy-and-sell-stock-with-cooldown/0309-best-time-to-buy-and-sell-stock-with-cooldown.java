class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return dp[prices.length -1][1];
    }
}

//(hold)dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
//(sell)dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//(cooldown)dp[i][2] = max(dp[i - 1][2], dp[i - 1][1]);