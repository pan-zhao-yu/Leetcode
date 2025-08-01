class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int n : nums){
            preSum += n;
            int comp = preSum - k;
            if(map.containsKey(comp)) res += map.get(comp);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            
        }
        return res;
    }
}