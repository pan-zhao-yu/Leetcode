class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums1){
            for(int x : nums2){
                map.put(n + x, map.getOrDefault(n + x, 0) + 1);
            }
        }
        for(int n : nums3){
            for(int x : nums4){
                res += map.getOrDefault(0 - n - x, 0);
            }
        }
        return res;
    }
}