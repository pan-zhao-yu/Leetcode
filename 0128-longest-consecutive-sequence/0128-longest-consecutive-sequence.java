class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int res = 0;
        for(int n : set){
            int count = 1;
            if(!set.contains(n - 1)){
                while(set.contains(n + 1)){
                    n++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}