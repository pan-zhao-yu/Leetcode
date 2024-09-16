class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // 使用 Set 记录列、正对角线和负对角线
        Set<Integer> columns = new HashSet<>();
        Set<Integer> positiveDiagonal = new HashSet<>();
        Set<Integer> negativeDiagonal = new HashSet<>();
        
        // 开始回溯
        backtrack(result, board, n, 0, columns, positiveDiagonal, negativeDiagonal);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char[][] board, int n, int row, Set<Integer> columns, Set<Integer> positiveDiagonal, Set<Integer> negativeDiagonal) {
        // 当所有行都放置好了皇后，记录结果
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            // 检查当前位置是否可以放置皇后
            if (!isValid(col, row, columns, positiveDiagonal, negativeDiagonal)) {
                continue;
            }
            
            // 放置皇后
            board[row][col] = 'Q';
            columns.add(col);
            positiveDiagonal.add(col + row);
            negativeDiagonal.add(col - row);
            
            // 递归进入下一行
            backtrack(result, board, n, row + 1, columns, positiveDiagonal, negativeDiagonal);
            
            // 回溯，撤销当前的选择
            board[row][col] = '.';
            columns.remove(col);
            positiveDiagonal.remove(col + row);
            negativeDiagonal.remove(col - row);
        }
    }
    
    // 验证当前点 (row, col) 是否可以放置皇后
    private boolean isValid(int col, int row, Set<Integer> columns, Set<Integer> positiveDiagonal, Set<Integer> negativeDiagonal) {
        int posiDiag = col + row;
        int negaDiag = col - row;
        // 检查列和两个对角线
        if (columns.contains(col) || positiveDiagonal.contains(posiDiag) || negativeDiagonal.contains(negaDiag)) {
            return false;
        }
        return true;
    }
}