class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            if(right - left == 1) return right;
            if(target < nums[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return -1;
    }
}