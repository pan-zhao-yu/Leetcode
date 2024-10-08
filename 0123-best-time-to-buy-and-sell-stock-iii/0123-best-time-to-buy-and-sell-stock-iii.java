class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }
}

//(1hold)dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//(1sell)dp[i][1] = Math.max(prices[i] + dp[i - 1][0], dp[i - 1][1]);
//(2hold)dp[i][2] = max(prices[i - 1][2], dp[i - 1][1] - prices[i]);
//(2sell)dp[i][3] = max(prices[i - 1][3], dp[i - 1][2] + prices[i]);