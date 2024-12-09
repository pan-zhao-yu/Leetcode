class Solution {
    public int maxProduct(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        int res = nums[0];
        for(int i = 0; i < len; i++){
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[len - 1 - i];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
}