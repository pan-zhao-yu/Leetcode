class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length()){
            while(map.containsKey(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }
            map.put(s.charAt(right), 1);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}