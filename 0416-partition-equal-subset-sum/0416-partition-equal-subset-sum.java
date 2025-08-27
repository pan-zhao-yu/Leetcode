class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int n : nums){
            for(int j = target; j > 0; j--){
                if(j >= n){
                    dp[j] = Math.max(dp[j], dp[j - n] + n);
                }
            }
        }
        return dp[target] == target;
    }
}