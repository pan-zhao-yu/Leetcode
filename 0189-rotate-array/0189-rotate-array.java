class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }
    
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }  
    }
}

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int[] res = new int[nums.length];
//         for(int i = 0; i < nums.length; i++){
//             res[(i + k) % nums.length] = nums[i];
//         }
//         for(int j = 0; j < nums.length; j++){
//             nums[j] = res[j];
//         }
//     }
// }