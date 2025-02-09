class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int reminder = target - nums[i];
            if(map.containsKey(reminder)){
                return new int[]{i, map.get(reminder)};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}