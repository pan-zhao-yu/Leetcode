class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        Set<Integer> columns = new HashSet<>(); //colum
        Set<Integer> positiveDiagonal = new HashSet<>(); //c + r
        Set<Integer> negativeDiagonal = new HashSet<>(); //c - r
        backtrack(result, board, n, 0, columns, positiveDiagonal, negativeDiagonal);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char[][] board, int n, int row, Set<Integer> columns, Set<Integer> postiveDiagonal, Set<Integer> negativeDiagonal){
        if(row == n){
            result.add(constructBoard(board));
            return;
        }
        for(int col = 0; col < n; col++){
            int diag1 = row - col;
            int diag2 = row + col;
            if(columns.contains(col) || postiveDiagonal.contains(diag1) || negativeDiagonal.contains(diag2)) continue;
            board[row][col] = 'Q';
            columns.add(col);
            postiveDiagonal.add(diag1);
            negativeDiagonal.add(diag2);
        
        backtrack(result, board, n, row + 1, columns, postiveDiagonal, negativeDiagonal);
        board[row][col] = '.';
        columns.remove(col);
        postiveDiagonal.remove(diag1);
        negativeDiagonal.remove(diag2);
        }
    } 
    
    private List<String> constructBoard(char[][] board){
        List<String> constructedBoard = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            constructedBoard.add(new String(board[i]));
        }
        return constructedBoard;
    }
}