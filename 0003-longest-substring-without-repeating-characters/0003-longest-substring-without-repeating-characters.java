class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSub = 0;
        Set<Character> hs = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxSub = Math.max(maxSub, hs.size());
        }
        return maxSub;
    }
}
