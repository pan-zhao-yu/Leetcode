class Solution {
    public int maxProfit(int[] prices) {
        int left = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            left = Math.min(left, prices[i]);
            profit = Math.max(profit, prices[i] - left);
        }
        return profit;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int[][] dp = new int[prices.length][2];
//         dp[0][0] = 0;
//         dp[0][1] = -prices[0];
//         for(int i = 1; i < prices.length; i++){
//             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//             dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//         }
//         return dp[prices.length - 1][0];
//     }
// }
// //dp[i][0] means the max cash we can have if sell or not holding any stock on ith day
// //dp[i][1] means the max cash we can have if buy or keep holding stock on ith day;