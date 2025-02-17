class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        map.put(0, 1);
        for(int n : nums){
            curr += n;
            int diff = curr - k;
            if(map.containsKey(diff)) res += map.get(diff);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
            return res;
    }
}