class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            // 左半有序
            if (nums[l] <= nums[m]) {
                // target 在左半 [l, m)
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else { // 否则去右半
                    l = m + 1;
                }
            } else { // 右半有序
                // target 在右半 (m, r]
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else { // 否则去左半
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
