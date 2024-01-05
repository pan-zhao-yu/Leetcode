class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                result = nums[i];
                count ++;
            }else if(result == nums[i]){
                count ++;
            }else{
                count --;
            }
        }
        return result;
        
        
        
//         int n = nums.length / 2;
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }
        
//         for(int i = 0; i < nums.length; i++){
//             if(map.get(nums[i]) > n){
//                 return nums[i];
//             }
            
//         }
//         return 0;
    }
}