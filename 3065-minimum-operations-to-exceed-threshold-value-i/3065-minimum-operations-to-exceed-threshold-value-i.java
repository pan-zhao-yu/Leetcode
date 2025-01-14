class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        while(nums[i] < k && i < nums.length){
            res++;
            i++;
        }
        return res;
    }
}