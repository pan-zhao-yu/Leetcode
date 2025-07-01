class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(char c : magazine.toCharArray()){
            map[c - 'a'] += 1;
        }
        for(char c : ransomNote.toCharArray()){
            if(map[c - 'a'] == 0) return false;
            else{
                map[c - 'a'] -= 1;
            }
        }
        return true;
    }
}