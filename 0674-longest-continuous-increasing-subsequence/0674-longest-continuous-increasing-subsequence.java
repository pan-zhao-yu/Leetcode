class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[right] > nums[right - 1]){
                result = Math.max(result, right - left + 1);
            }else{
                left = right;
            }
            right++;
        }
        return result;
    }
}