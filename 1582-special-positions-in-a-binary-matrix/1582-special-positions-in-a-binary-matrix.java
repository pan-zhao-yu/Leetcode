class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int result = 0;
        int[] m = new int[row];
        int[] n = new int[col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1){
                    m[i]++;
                    n[j]++;
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1 && m[i] == 1 && n[j] == 1) result++;
            }
        }
        return result;
    }
}