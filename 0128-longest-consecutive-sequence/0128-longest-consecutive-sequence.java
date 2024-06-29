class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n : nums){
            set.add(n);
        }
        for(int n : set){
            int count = 1;
            if(!set.contains(n - 1)){
                while(set.contains(n + 1)){
                    count++;
                    n++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}