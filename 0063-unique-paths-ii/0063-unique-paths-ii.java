class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[row - 1][col - 1] == 1) return 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == -1) break;
            obstacleGrid[i][0] = 1;
        }
        for(int j = 0; j < col; j++){
            if(obstacleGrid[0][j] == -1) break;
            obstacleGrid[0][j] = 1;
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] != -1){
                    int up = Math.max(0, obstacleGrid[i - 1][j]);
                    int left = Math.max(0, obstacleGrid[i][j - 1]);
                    obstacleGrid[i][j] = up + left;
                }
                
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
}