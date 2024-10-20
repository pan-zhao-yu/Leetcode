class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 && word2.length() == 0) return 0;
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;  // Deleting all characters from word1 to match an empty word2
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;  // Inserting all characters from word2 to match an empty word1
        }
        
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}