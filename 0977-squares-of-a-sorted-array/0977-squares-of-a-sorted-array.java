class Solution {
    public int[] sortedSquares(int[] nums) {
     int left = 0, right = nums.length -1, len = nums.length -1;
        int[] result = new int[nums.length];
        while(left <= right){
            if(nums[left] * nums[left]  < nums[right] * nums[right]){
                result[len] = nums[right] * nums[right];
                len--;
                right--;
            }else{
                result[len] = nums[left] * nums[left];
                len--;
                left++;
            }
        }
        return result;
    }
}