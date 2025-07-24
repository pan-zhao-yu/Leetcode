class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int r = 0; r < obstacleGrid.length; r++){
            if(obstacleGrid[r][0] == 1) break;
            dp[r][0] = 1;
        }
        for(int c = 0; c < obstacleGrid[0].length; c++){
            if(obstacleGrid[0][c] == 1) break;
            dp[0][c] = 1;
        }
        for(int r = 1; r < obstacleGrid.length; r++){
            for(int c = 1; c < obstacleGrid[0].length; c++){
                if(obstacleGrid[r][c] == 1) continue;
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}