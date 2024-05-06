class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int leftVal = mid - 1 == -1 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightVal = mid + 1 == nums.length ? Integer.MIN_VALUE : nums[mid + 1];
            if(nums[mid] > leftVal && nums[mid] > rightVal){
                return mid;
            }else if(nums[mid] >= leftVal){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}