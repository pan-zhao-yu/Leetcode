class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
            int lb = mid, rb = mid;
                while(lb - 1 >= 0 && nums[lb] == nums[lb - 1]) lb -= 1;
                while(rb + 1 < nums.length && nums[rb] == nums[rb + 1]) rb += 1;
                return new int[]{lb, rb};
            }
        }
        return new int[]{-1, -1};
    }
}