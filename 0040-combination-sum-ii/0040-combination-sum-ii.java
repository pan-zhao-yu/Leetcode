class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(temp));
        else{
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                backtrack(result, temp, candidates, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

// public List<List<Integer>> combinationSum2(int[] nums, int target) {
//     List<List<Integer>> list = new ArrayList<>();
//     Arrays.sort(nums);
//     backtrack(list, new ArrayList<>(), nums, target, 0);
//     return list;
    
// }

// private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
//     if(remain < 0) return;
//     else if(remain == 0) list.add(new ArrayList<>(tempList));
//     else{
//         for(int i = start; i < nums.length; i++){
//             if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
//             tempList.add(nums[i]);
//             backtrack(list, tempList, nums, remain - nums[i], i + 1);
//             tempList.remove(tempList.size() - 1); 
//         }
//     }
// } 