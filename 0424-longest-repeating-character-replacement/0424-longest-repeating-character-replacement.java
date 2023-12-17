class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] count = new int[26];
        
        for(right = 0; right < s.length() ; right ++){
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            
            while(right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A'] --;
                left++;
                
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}