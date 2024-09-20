class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList(), k, n, 1);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int k, int n, int start){
        // if(n < 0 || temp.size() > k) return;
        if(temp.size() == k && n == 0){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= 9; i++){
            if(n > 0){
                temp.add(i);
                backtrack(res, temp, k, n - i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}