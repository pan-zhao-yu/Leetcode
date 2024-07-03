class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1M = new int[26];
        int[] s2M = new int[26];
        for(char c : s1.toCharArray()){
            s1M[c - 'a']++;
        }
        int right = 0;
        int left = 0;
        while(right < s2.length()){
            s2M[s2.charAt(right) - 'a']++;
            if((right - left + 1) > s1.length()){
                s2M[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(s1M, s2M)) return true;
            right++;
        }
        return false;
    }
}