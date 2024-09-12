class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList(), candidates, target, 0, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start, int sum){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            sum += candidates[i];
            backtrack(res, temp, candidates, target, i + 1, sum);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }
}