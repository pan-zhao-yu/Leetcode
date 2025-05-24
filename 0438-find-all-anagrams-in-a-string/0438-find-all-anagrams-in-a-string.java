class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pMap = new int[26];
        int[] window = new int[26];
        for(char c : p.toCharArray()){
            pMap[c - 'a']++;
        }
        int r = 0;
        while(r < s.length()){
            window[s.charAt(r) - 'a']++;
            if(r + 1 - p.length() >= 0){
                if(isAnagram(window, pMap)){
                    res.add(r + 1 - p.length());
                }
                window[s.charAt(r + 1 - p.length()) - 'a']--;
            }

            r++;
        }
        return res;
    }
    private boolean isAnagram(int[] window, int[] pMap){
        for(int i = 0; i < window.length; i++){
            if(window[i] != pMap[i]) return false;
        }
        return true;
    }
}