class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1; // Special case
        if (n == 3) return 2; // Special case
        
        int[] dp = new int[n + 1];
        dp[1] = 1; // This value won't be used for n >= 4
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        
        return dp[n];
    }
}

//dp[i] = j * dp[i - j];
//dp[i] = j * (i - j);
