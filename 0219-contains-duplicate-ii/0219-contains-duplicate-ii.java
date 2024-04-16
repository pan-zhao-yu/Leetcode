class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashmap.containsKey(nums[i])){
                if(Math.abs(i - hashmap.get(nums[i])) <= k){
                    return true;
                }
            }
            hashmap.put(nums[i], i);
        }
        return false;
    }
}