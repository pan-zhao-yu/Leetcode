class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return result;
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordCount * wordLength;
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i <= s.length() - totalLength; i++){
            if(isValidSubstring(s.substring(i, i + totalLength), wordMap, wordLength)){
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean isValidSubstring(String substring, Map<String, Integer> wordMap, int wordLength){
        Map<String, Integer> seenWords = new HashMap<>();
        for(int j = 0; j < substring.length(); j += wordLength){
            String word = substring.substring(j, j + wordLength);
            if(!wordMap.containsKey(word)){
                return false;
            }
            seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
            if(seenWords.get(word) > wordMap.get(word)){
                return false;
            }
        }
        return true;
    }
}


