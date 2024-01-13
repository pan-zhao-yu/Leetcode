class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found at index mid
            } else if (nums[mid] < target) {
                left = mid + 1; // Target must be in the right half
            } else {
                right = mid - 1; // Target must be in the left half
            }
        }

        return left; // Target not found, return the index where it should be inserted
    }
}