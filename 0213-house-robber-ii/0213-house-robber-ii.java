class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int startFromFirst = dp(nums, 0, nums.length - 2);
        int startFromSec = dp(nums, 1, nums.length - 1);
        return Math.max(startFromFirst, startFromSec);
    }
    private int dp(int[] nums, int start, int end){
        int dp1 = 0;
        int dp2 = 0;
        for(int i = start; i <= end; i++){
            int temp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }
}