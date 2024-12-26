class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(res, temp, s, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, List<String> temp, String s, int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){
                temp.add(s.substring(idx, i + 1));
                backtrack(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
        }
        
    }
    
    private boolean isPalindrome(String str, int left, int right){
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}    