class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res, temp, nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i : nums){
            if(!temp.contains(i)){
                temp.add(i);
                backtrack(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}