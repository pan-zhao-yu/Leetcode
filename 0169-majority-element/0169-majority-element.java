class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        for(Integer num : map.keySet()){
            if(map.get(num) > n) return num;
        }
        return 0;
    }
}


// class Solution {
//     public int majorityElement(int[] nums) {
//         int result = nums[0];
//         int count = 1;
        
//         for(int i = 1; i < nums.length; i++){
//             if(count == 0){
//                 result = nums[i];
//                 count ++;
//             }else if(result == nums[i]){
//                 count ++;
//             }else{
//                 count --;
//             }
//         }
//         return result;
//     }
// }