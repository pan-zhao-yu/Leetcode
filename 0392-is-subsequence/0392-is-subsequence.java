class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int result = 0;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return result == s.length();
    }
}