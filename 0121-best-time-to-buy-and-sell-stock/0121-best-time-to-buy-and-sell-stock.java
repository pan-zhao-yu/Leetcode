class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int currLow = Integer.MAX_VALUE;
//         int res = 0;
//         for(int n : prices){
//             currLow = Math.min(n, currLow);
//             res = Math.max(res, n - currLow);
//         }
//         return res;
//     }
// }