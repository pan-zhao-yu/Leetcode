class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = 0; j < s.length(); j++){
                if(j - i >= 2){
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i + 1][j - 1]){
                            dp[i][j] = dp[i + 1][j - 1];
                            result++;
                        }
                    }
                }else if(j - i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    result++;
                }else if(j == i){
                    dp[i][j] = true;
                    result++;
                }
                
            }
        }
        return result;
    }
}
//if(s[i] == s[j]) 
// if(dp[i + 1][j - 1]) dp[i][j] = dp[i + 1][j - 1];