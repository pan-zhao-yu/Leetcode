class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res, temp, candidates, 0, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int curr, int target, int start){
        if(curr > target) return;
        if(curr == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(res, temp, candidates, curr + candidates[i], target, i);
            temp.remove(temp.size() - 1);
        }
    }
}