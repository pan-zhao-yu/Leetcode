class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)) return false;
            if(map.get(c) - 1 == 0){
                map.remove(c);
            }else{
                map.put(c, map.get(c) - 1);
            }
        }
        return map.isEmpty();
    }
}




// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
        
//         int[] str = new int[26];
        
//         for(int i = 0; i < s.length(); i++){
//             str[s.charAt(i) - 'a'] ++;
//             str[t.charAt(i) - 'a'] --;
//         }
//         for(int n : str){
//             if(n != 0) return false;
//         }
//         return true;
//     }
// }

        // if(s.length() != t.length()){
        //     return false;
        // }
        // char[] str1 = s.toLowerCase().toCharArray();
        // char[] str2 = t.toLowerCase().toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // return Arrays.equals(str1, str2);


// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(char ch : s.toCharArray()){
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//         for(char c : t.toCharArray()){
//             if(!map.containsKey(c)){
//                 return false;
//             }
//             int n = map.get(c) - 1;
//             if(n == 0){
//                 map.remove(c);
//             }else{
//                 map.put(c, n);
//             }
//         }
//             return map.isEmpty();
//     }
// }