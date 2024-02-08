class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0){
            res.add(new ArrayList(temp));
        }else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() -1);
            }
        }
    }
}