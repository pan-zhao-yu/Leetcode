class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(k, n, res, temp, 1, 0);
        return res;
    }
    private void backtrack(int k, int n, List<List<Integer>> res, List<Integer> temp, int start, int sum){
        if(temp.size() > k || sum > n) return;
        if(sum == n && temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= 9; i++){
            temp.add(i);
            sum += i;
            backtrack(k, n, res, temp, i + 1, sum);
            temp.remove(temp.size() - 1);
            sum -= i;
        }
    }
}