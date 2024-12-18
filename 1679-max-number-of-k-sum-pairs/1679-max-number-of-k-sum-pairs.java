class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = 0;
        while(left < right){
            int curr = nums[left] + nums[right];
            if(curr > k){
                right--;
            }else if(curr < k){
                left++;
            }else{
                res += 1;
                left++;
                right--;
            }
        }
        return res;
    }
}