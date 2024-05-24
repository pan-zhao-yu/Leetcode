class Solution {
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        reverse(nums);
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        target = sum / k;
        return backtrack(nums, 0, k, 0, used);
    }
    private boolean backtrack(int[] nums, int start, int k, int subsetSum, boolean[] used){
        if(k == 0) return true;
        if(subsetSum == target) return backtrack(nums, 0, k - 1, 0, used);
        for(int i = start; i < nums.length; i++){
            if(i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;
            if(used[i] || subsetSum + nums[i] > target) continue;
            used[i] = true;
            if(backtrack(nums, i + 1, k, subsetSum + nums[i], used)) return true;
            used[i] = false;
        }
        return false;
    }
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
