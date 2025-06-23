class Solution {
    public void nextPermutation(int[] nums) {
        //find the breakpoint(first decresing)
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //in case nums already bigest, reverse nums to return answer e.g. Example2
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        //find the smallest num from right part while bigger than nums[i]
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        //swap
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}