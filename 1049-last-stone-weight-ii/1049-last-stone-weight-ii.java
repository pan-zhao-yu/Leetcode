class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int n : stones){
            sum += n;
        }
        int[][] dp = new int[sum / 2 + 1][stones.length];
        for(int j = 0; j < stones.length; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i < sum / 2 + 1; i++){
            if(i >= stones[0]) dp[i][0] = stones[0];
        }
        for(int i = 1; i < sum / 2 + 1; i++){
            for(int j = 1; j < stones.length; j++){
                if(i >= stones[j]) dp[i][j] = Math.max(dp[i][j - 1], dp[i - stones[j]][j - 1] + stones[j]);
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return sum - 2 * dp[sum / 2][stones.length - 1];
    }
}