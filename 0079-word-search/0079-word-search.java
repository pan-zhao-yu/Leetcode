class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, word, i, j, row, col, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int row, int col, int index){
        if(index >= word.length()) return true;
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(index)) return false;
        boolean exist = false;
        if(board[i][j] == word.charAt(index)){
            board[i][j] += 100;
            exist = dfs(board, word, i + 1, j, row, col, index + 1) ||
                    dfs(board, word, i, j + 1, row, col, index + 1) ||
                    dfs(board, word, i - 1, j, row, col, index + 1) ||
                    dfs(board, word, i, j - 1, row, col, index + 1); 
            board[i][j] -= 100;
        }
        return exist;
    }
}