class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        int[] pMap = new int[26];
        for(char c : p.toCharArray()){
            pMap[c - 'a'] += 1;
        }
        int[] sMap = new int[26];
        while(r < s.length()){
            while(r - l >= p.length()){
                sMap[s.charAt(l) - 'a'] -= 1;
                l++;
            }
            sMap[s.charAt(r) - 'a'] += 1;
            r++;
            if(Arrays.equals(sMap, pMap)) res.add(l);
        }
        return res;
    }
}