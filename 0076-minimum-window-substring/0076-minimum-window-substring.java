class Solution {
    public String minWindow(String s, String t) {
        HashMap <Character, Integer> tMap =  new HashMap<>();
        
        for(char x : t.toCharArray()){
            tMap.put(x, tMap.getOrDefault(x,0) + 1);
        }
        
        int matched = 0;
        int left = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        
        for(int endWindow = 0; endWindow < s.length(); endWindow++){
            char right = s.charAt(endWindow);
            if(tMap.containsKey(right)){
                tMap.put(right, tMap.get(right)-1);
                if(tMap.get(right) == 0) matched++;
            }
            
            while(matched == tMap.size()){
                if(minLen > endWindow - left + 1){
                    minLen = endWindow - left + 1;
                    subStr = left;
                }
                
                char deleted = s.charAt(left++);
                if(tMap.containsKey(deleted)){
                    if(tMap.get(deleted) == 0)matched--;
                    tMap.put(deleted, tMap.get(deleted) + 1);
                }
            }
            
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}