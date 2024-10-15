class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        int maxLen = 0;
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }
        return maxLen;
    }
}
//dp[i][j] = at i th element from nums1, at j th element from nums2, max repeated subarray len;
//if(nums1[i] == nums2[j]) dp[i][j] = dp[i - 1][j - 1] + 1