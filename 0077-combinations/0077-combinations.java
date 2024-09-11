class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result, n, k, 1, temp);
        return result;
    }
    private void backtrack(List<List<Integer>> result, int n, int k, int start, List<Integer> temp){
        if(temp.size() == k){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= n; i++){
            temp.add(i);
            backtrack(result, n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}