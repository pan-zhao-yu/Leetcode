class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            int n = map.get(c) - 1;
            if(n == 0){
                map.remove(c);
            }else{
                map.put(c, n);
            }
        }
            return map.isEmpty();
    }
}

        // if(s.length() != t.length()){
        //     return false;
        // }
        // char[] str1 = s.toLowerCase().toCharArray();
        // char[] str2 = t.toLowerCase().toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // return Arrays.equals(str1, str2);