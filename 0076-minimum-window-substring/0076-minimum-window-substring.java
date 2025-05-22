class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, miniLen = Integer.MAX_VALUE, miniLeft = s.length(), miniRight = s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int need = tMap.size();
        int found = 0;
        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length()){
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            if(tMap.containsKey(s.charAt(right)) && window.get(s.charAt(right)).intValue() == tMap.get(s.charAt(right)).intValue()){
                found++;
            }
            right++;
            while(found == need){
                if(right - left < miniLen){
                    miniLeft = left;
                    miniRight = right;
                    miniLen = right - left;
                }
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if(tMap.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < tMap.get(s.charAt(left))){
                    found--;
                }
                left++;
            }
            
        }
        return miniLen > s.length() ? "" : s.substring(miniLeft, miniRight);
    }
}