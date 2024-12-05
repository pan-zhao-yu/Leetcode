class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        // Find the leftmost index of target
        int left = findBound(nums, target, true);
        if (left == -1) return res; // If target is not found, return [-1, -1]

        // Find the rightmost index of target
        int right = findBound(nums, target, false);

        res[0] = left;
        res[1] = right;
        return res;
    }

    private int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isLeft) {
                    // Narrow down to the left
                    if (mid == 0 || nums[mid - 1] != target) return mid;
                    right = mid - 1;
                } else {
                    // Narrow down to the right
                    if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
