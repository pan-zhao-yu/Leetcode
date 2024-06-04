class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magaMap = new HashMap<>();
        for(char c : magazine.toCharArray()){
            magaMap.put(c, magaMap.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!magaMap.containsKey(c) || magaMap.get(c) == 0){
                return false;
            }
            magaMap.put(c, magaMap.get(c) - 1);
        }
        return true;
    }
}