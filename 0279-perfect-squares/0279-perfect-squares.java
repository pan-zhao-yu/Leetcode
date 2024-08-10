class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new LinkedList<>();
        for(int i = 1; i * i <= n; i++){
            squares.add(i * i);
        }
        int[][] dp = new int[squares.size() + 1][n + 1];
        for(int i = 0; i <= squares.size(); i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        for(int i = 1; i <= squares.size(); i++){
            for(int j = 1; j <= n; j++){
                if(j >= squares.get(i - 1)){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - squares.get(i - 1)] + 1);
                }else{
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[squares.size()][n];
    }
}