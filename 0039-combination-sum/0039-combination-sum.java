class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res, temp, candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}