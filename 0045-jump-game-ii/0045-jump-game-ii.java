class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        while(right < nums.length - 1){
            int farest = 0;
            for(int i = left; i < right + 1; i++){
                farest = Math.max(nums[i] + i, farest);
            }
            right = farest;
            res++;
        }
        return res;
    }
}

// public class Solution {
//     public int jump(int[] nums) {
//         if (nums.length <= 1) {
//             return 0;
//         }

//         int jumps = 1, maxReach = nums[0], steps = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             if (i == nums.length - 1) {
//                 return jumps;
//             }

//             maxReach = Math.max(maxReach, i + nums[i]);
//             steps--;

//             if (steps == 0) {
//                 jumps++;
//                 if (i >= maxReach) {
//                     return -1; // Cannot reach the end
//                 }
//                 steps = maxReach - i;
//             }
//         }

//         return jumps;
//     }
// }