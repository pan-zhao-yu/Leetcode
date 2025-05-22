class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int need = tMap.size();
        int miniLen = Integer.MAX_VALUE;
        int left = 0;
        while(r < s.length()){
            if(tMap.containsKey(s.charAt(r))){
                tMap.put(s.charAt(r), tMap.get(s.charAt(r)) - 1);
                if(tMap.get(s.charAt(r)) == 0) need--;
            }
            r++;
            while(need == 0){
                if(r - l < miniLen){
                    miniLen = r - l;
                    left = l;
                }
                if(tMap.containsKey(s.charAt(l))){
                    tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                    if(tMap.get(s.charAt(l)) > 0) need++;
                }
                l++;
            }
        }
        return miniLen == Integer.MAX_VALUE ? "" : s.substring(left, left + miniLen);
    }
}