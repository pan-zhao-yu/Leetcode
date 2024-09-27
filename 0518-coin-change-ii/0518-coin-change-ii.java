class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
//dp[j] means how many ways we can make up to amount j
//dp[j] = dp[j] + dp[j - coins];


// class Solution {
//     public int change(int amount, int[] coins) {
//         int[][] dp = new int[coins.length + 1][amount + 1];
//         for(int i = 0; i <= coins.length; i++){
//             dp[i][0] = 1;
//         }
//         for(int i = 1; i <= coins.length; i++){
//             for(int j = 1; j <= amount; j++){
//                 if(j >= coins[i - 1]){
//                     dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                 }else{
//                     dp[i][j] = dp[i - 1][j];
//                 }
//                 System.out.print(dp[i][j] + " ");
//             }
//             System.out.println(" ");
//         }
//         return dp[coins.length][amount];
//     }
// }
// //dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]