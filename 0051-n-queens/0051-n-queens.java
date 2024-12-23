class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        dfs(n, 1, new int[n+1]);
        return ans;
    }
    void dfs(int n, int idx, int[] pos){
        if(idx > n){
            ans.add(newStr(pos, n));
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!validPos(pos, i, idx)){
                continue;
            }
            pos[idx] = i;
            dfs(n, idx+1, pos);
            pos[idx] = 0;
        }
    }
    boolean validPos(int[] pos, int i, int idx){
        for(int j = 1; j < idx; j++){
            if(pos[j] == i){
                return false;
            }
            if(Math.abs(idx-j) == Math.abs(i-pos[j])){
                return false;
            }
        }
        return true;
    }
    List<String> newStr(int[] pos, int n){
        List<String> path = new ArrayList();
        for(int i = 1; i <= n; i++){
            path.add(newStrAssi(pos[i], n));
        }
        return path;
    }
    String newStrAssi(int i, int n){
        StringBuffer sb = new StringBuffer();
        for(int j = 1; j <= n; j++){
            sb.append(i == j ? 'Q':'.');
        }
        return sb.toString();
    }
}