class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                i++;
            }else{
                nums[j] = nums[i];
                i++;
                j++;
            }
        }
        for(i = nums.length - 1; i >= j; i--){
            nums[i] = 0;
        }
    }
}