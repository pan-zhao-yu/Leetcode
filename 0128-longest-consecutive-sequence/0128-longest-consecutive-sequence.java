class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        if(nums.length == 0){
            return 0;
        }
        HashSet <Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        for(int num : nums){
            if(!hs.contains(num-1)){
                int count = 1;
                while(hs.contains(num+1)){
                    count ++;
                    num++;
                }
            longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}