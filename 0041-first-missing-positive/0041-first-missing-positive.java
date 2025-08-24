class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) return nums[0] == 1 ? 2 : 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] >= 0 && nums[i] < nums.length && nums[i] != i && nums[i] != nums[nums[i]]){
                int curr = nums[i];
                nums[i] = nums[curr];
                nums[curr] = curr;
            }
        }
        int res = nums.length;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != i) return i;
        }
        return nums[0] == nums.length ? nums.length + 1 : nums.length;
    }
}