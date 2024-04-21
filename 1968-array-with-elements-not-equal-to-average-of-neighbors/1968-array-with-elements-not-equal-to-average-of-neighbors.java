class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while(i < nums.length){
            res[i] = nums[left];
            i++;
            left++;
            if(nums[right] >= nums[left]){
                res[i] = nums[right];
                i++;
                right--;
            }
        }
        return res;
    }
}