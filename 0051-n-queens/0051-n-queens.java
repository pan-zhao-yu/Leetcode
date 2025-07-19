class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = '.';
            }
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> pos = new HashSet<>();
        Set<Integer> neg = new HashSet<>();
        backtrack(res, grid, col, pos, neg, n, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] grid, Set<Integer> col, Set<Integer> pos, Set<Integer> neg, int n, int row){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(grid[i]));
            }
            res.add(temp);
        }

        for(int i = 0; i < n; i++){
            if(col.contains(i) || pos.contains(row + i) || neg.contains(row - i)) continue;
            grid[row][i] = 'Q';
            col.add(i);
            pos.add(row + i);
            neg.add(row - i);
            backtrack(res, grid, col, pos, neg, n, row + 1);
            grid[row][i] = '.';
            col.remove(i);
            pos.remove(row + i);
            neg.remove(row - i);
        }
    }
}