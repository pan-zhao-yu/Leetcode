class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : s.toCharArray()){
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         for(char c : t.toCharArray()){
//             if(map.containsKey(c) && map.get(c) > 0){
//                 map.put(c, map.get(c) - 1);
//             }else{
//                 return false;
//             }
//         }
//         return !map.values().stream().anyMatch(value -> value > 0);
//     }
// }