class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        int left = 0, right = 0;
        if(s.length() < 2) return s;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(j - i + 1 > maxLen){
                            maxLen = j - i + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}