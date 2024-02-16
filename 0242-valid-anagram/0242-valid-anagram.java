class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Count the frequency of characters in s
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Decrement the frequency of characters in t
        for (char c : t.toCharArray()) {
            if (!charFrequency.containsKey(c)) {
                return false; // Character not present in s
            }

            int newCount = charFrequency.get(c) - 1;
            if (newCount == 0) {
                charFrequency.remove(c);
            } else {
                charFrequency.put(c, newCount);
            }
        }

        return charFrequency.isEmpty();
    }
}

        // if(s.length() != t.length()){
        //     return false;
        // }
        // char[] str1 = s.toLowerCase().toCharArray();
        // char[] str2 = t.toLowerCase().toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // return Arrays.equals(str1, str2);