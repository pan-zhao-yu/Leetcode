class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j <= 2){
                        dp[i][j] = true;
                        res++;
                    }else{
                        dp[i][j] = dp[i - 1][j + 1];
                        if(dp[i][j]) res++;
                    }
                }
            }
        }
        return res;
    }
}