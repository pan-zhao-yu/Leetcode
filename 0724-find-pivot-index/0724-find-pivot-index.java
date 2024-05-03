class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;
        for(int n : nums){
            sum += n;
        }
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                left += nums[i - 1];
            }
            sum -= nums[i];
            if(left == sum){
                return i;
            }
        }
        return -1;
    }
}