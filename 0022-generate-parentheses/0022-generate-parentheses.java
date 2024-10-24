class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String temp, int left, int right, int max){
        if(temp.length() == max * 2){
            result.add(temp);
        }
        if(left < max){
            backtrack(result, temp + "(", left + 1, right, max);
        }
        if(right < left){
            backtrack(result, temp + ")", left, right + 1, max);
        }
    }
}