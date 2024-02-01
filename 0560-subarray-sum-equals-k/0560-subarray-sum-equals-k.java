class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int num : nums){
            prefixSum += num;
            int diff = prefixSum - k;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}