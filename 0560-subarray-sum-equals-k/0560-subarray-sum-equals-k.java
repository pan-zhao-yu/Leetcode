class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;
        map.put(0, 1);
        for(int n : nums){
            sum += n;
            int diff = sum - k;
            if(map.containsKey(diff)){
                res += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
            return res;
    }
}