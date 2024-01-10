public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWordMap.containsKey(ch)) {
                if (!charToWordMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (wordToCharMap.containsKey(word)) {
                    if(!wordToCharMap.get(word).equals(ch)){
                        return false;
                    }
                }else{
                    charToWordMap.put(ch, word);
                    wordToCharMap.put(word, ch);
                }
            }
        }
        return true;
    }
}
