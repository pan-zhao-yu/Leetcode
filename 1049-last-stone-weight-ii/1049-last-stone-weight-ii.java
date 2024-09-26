class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        for(int i = 0; i <= stones.length; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= stones.length; i++){
            for(int j = 0; j <= target; j++){
                if(j >= stones[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[stones.length][target];
    }
}
//dp[i][j] means the max sum we can achive by using the first i th element, in range j
//dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);