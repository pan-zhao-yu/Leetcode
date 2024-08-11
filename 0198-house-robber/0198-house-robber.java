class Solution {
    public int rob(int[] nums) {
        int dp1 = 0;
        int dp2 = 0;
        for(int n : nums){
            int temp = Math.max(dp1 + n, dp2);
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }
}