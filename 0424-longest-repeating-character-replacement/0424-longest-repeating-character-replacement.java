class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] freq = new int[26];
        int mostFreq = 0;
        while(right < s.length()){
            char rightC = s.charAt(right);
            freq[rightC - 'A']++;
            mostFreq = Math.max(mostFreq, freq[rightC - 'A']);
            while((right - left + 1) - mostFreq > k){
                char leftC = s.charAt(left);
                freq[leftC - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}