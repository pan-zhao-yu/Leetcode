class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        int left = 0;
        int result = 0;
        int count = 0;
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        for(int right = 0; right < s.length(); right++){
            count += vowels.contains(s.charAt(right)) ? 1 : 0;
            if(right - left + 1 > k){
                count -= vowels.contains(s.charAt(left)) ? 1 : 0;
                left++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}