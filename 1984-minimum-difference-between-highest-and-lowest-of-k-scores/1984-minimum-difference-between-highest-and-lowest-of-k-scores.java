class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length == 1){
            return 0;
        }
        int minimum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - k + 1; i++){
            int diff = nums[i + k - 1] - nums[i];
            minimum = Math.min(diff, minimum);
        }
        return minimum;
    }
}