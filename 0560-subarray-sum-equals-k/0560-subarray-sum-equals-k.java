class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            sum += num;
            int diff = sum - k;
            
            if(map.containsKey(diff)){
                res += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}