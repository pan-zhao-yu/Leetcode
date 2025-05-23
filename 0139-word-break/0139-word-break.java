class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(set.contains(s.substring(j, i)) && valid[j]){
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}