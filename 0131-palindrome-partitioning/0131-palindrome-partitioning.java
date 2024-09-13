class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList(), s, 0);
        return res;
    }
    private void backtrack(List<List<String>> res, List<String> temp, String s, int start){
        if(start == s.length()){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                temp.add(s.substring(start, i + 1));
                backtrack(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}