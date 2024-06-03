class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int subStr = 0;
        int matched = 0;
        int minLen = Integer.MAX_VALUE;
        for(int end = 0; end < s.length(); end++){
            char right = s.charAt(end);
            if(tMap.containsKey(right)){
                tMap.put(right, tMap.get(right) - 1);
                if(tMap.get(right) == 0) matched++;
            }
            while(matched == tMap.size()){
                if(minLen > end - left + 1){
                    minLen = end - left + 1;
                    subStr = left;
                }
                char deleted = s.charAt(left++);
                if(tMap.containsKey(deleted)){
                    if(tMap.get(deleted) == 0) matched--;
                    tMap.put(deleted, tMap.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}

