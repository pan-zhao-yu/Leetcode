class Solution {
    public int waysToSplitArray(int[] nums) {
        int res = 0;
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            if (leftSum >= rightSum)
                res++;
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