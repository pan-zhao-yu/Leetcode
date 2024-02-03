class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int left = 0, right = len;
        int[] ans = new int[len * 2];
        for(int n : nums){
            ans[left] = n;
            ans[right] = n;
            left++;
            right++;
        }
        return ans;
    }
}