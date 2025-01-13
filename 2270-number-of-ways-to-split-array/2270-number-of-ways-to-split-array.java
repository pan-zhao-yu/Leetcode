class Solution {
    public int waysToSplitArray(int[] nums) {
        long left = 0, right = 0;
        int res = 0;
        long total = 0;
        for(int n : nums){
            total += n;
        }
        for(int i = 0; i < nums.length - 1; i++){
            left += nums[i];
            right = total - left;
            if(left >= right) res++;
        }
        return res;
    }
}

// class Solution {
// public int waysToSplitArray(int[] nums) {
// int res = 0;
// for(int i = 0; i < nums.length - 1; i++){
// int leftSum = 0, rightSum = 0;
// for(int left = 0; left <= i; left++){
// leftSum += nums[left];
// }
// for(int right = i; right <= nums.length - 1; right++){
// rightSum += nums[right];
// }
// if(leftSum >= rightSum) res++; //
// }
// return res;
// }
// }