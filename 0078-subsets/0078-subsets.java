class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res, temp, nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        res.add(new ArrayList(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}