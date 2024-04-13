class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}

// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int n = nums.length;

//     // Move positive integers to their correct positions
//     for (int i = 0; i < n; i++) {
//         while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
//             int temp = nums[nums[i] - 1];
//             nums[nums[i] - 1] = nums[i];
//             nums[i] = temp;
//         }
//     }

//     // Find the first missing positive integer
//     for (int i = 0; i < n; i++) {
//         if (nums[i] != i + 1) {
//             return i + 1;
//         }
//     }

//     return n + 1;
//     }
// }