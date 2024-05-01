class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = {-1, -1};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return findEdge(mid, nums, target); // Call findEdge directly and return its result
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result; // Return [-1, -1] if target is not found
    }
    
    private int[] findEdge(int mid, int[] nums, int target) {
        int left = mid;
        int right = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1}; // Adjust indices to represent the range
    }
}
