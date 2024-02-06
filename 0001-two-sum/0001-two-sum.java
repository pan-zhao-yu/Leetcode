class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}



// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int n = nums.length;
//         for(int i = 0; i < n; i++){
//             map.put(nums[i], i);
//         }
//         for(int i = 0; i < n; i++){
//             int complement = target - nums[i];
//             if(map.containsKey(complement) && map.get(complement) != i){
//                 return new int[]{i, map.get(complement)};
//             }
//         }
//         return new int[]{};
//     }
// }

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         for(int i = 0; i <= n - 1; i++){
//             for(int j = i + 1; j <= n - 1; j++){
//                 if(nums[i] + nums[j] == target){
//                     return new int[] {i, j};
//                 }
//             }
//         }
//         return new int[]{};
//     }
// }

