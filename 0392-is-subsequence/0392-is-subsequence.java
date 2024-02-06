class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int indexS = 0;
        int indexT = 0;
        while(indexS < s.length() && indexT < t.length()){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
            }
            indexT++;
        }
        return indexS == s.length();
    }
}