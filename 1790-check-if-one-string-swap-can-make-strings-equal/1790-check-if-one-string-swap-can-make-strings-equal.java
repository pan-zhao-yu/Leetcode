class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int[] mismatch = new int[2];
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(count >= 2) return false;
                mismatch[count++] = i;
            }
        }
        return count == 2 && s1.charAt(mismatch[0]) == s2.charAt(mismatch[1]) && s1.charAt(mismatch[1]) == s2.charAt(mismatch[0]);
    }
}