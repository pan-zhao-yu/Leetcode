class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for(int n : nums){
            if(n < k) res++;
        }
        return res;
    }
}


// class Solution {
//     public int minOperations(int[] nums, int k) {
//         int res = 0;
//         Arrays.sort(nums);
//         int i = 0;
//         while(nums[i] < k && i < nums.length){
//             res++;
//             i++;
//         }
//         return res;
//     }
// }