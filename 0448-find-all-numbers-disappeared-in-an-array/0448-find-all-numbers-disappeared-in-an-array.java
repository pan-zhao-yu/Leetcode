class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /*in range sorting*/
        for(int i = 0; i < nums.length; i++){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                result.add(i + 1);
            }
        }
        return result;
    }
}