class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 0;
        backtrack(res, temp, nums, start);
        return res;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}