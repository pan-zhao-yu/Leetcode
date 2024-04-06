class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majority = nums.length / 2;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > majority){
                return key;
            }
        }
        return 0;
    }
}

// class Solution {
//     public int majorityElement(int[] nums) {
//         int majority = nums[0];
//         int count = 1;
//         for(int i = 1; i < nums.length; i++){
//             if(count == 0){
//                 majority = nums[i];
//                 count++;
//             }else if(nums[i] == majority){
//                 count++;
//             }else{
//                 count--;
//             }
//         }
//         return majority;
//     }
// }


// class Solution {
//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int majorElement = nums[0];
//         int majority = nums.length / 2;
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             if(map.get(num) > majority) return num;
//         }
//         return 0;
//     }
// }