class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String curr = "";
        backtrack(result, curr, 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String curr, int left, int right, int max){
        if(curr.length() == max * 2){
            result.add(curr);
            return;
        }
        if(left < max){
            backtrack(result, curr + '(', left + 1, right, max);
        }
        if(right < left){
            backtrack(result, curr + ')', left, right + 1, max);
        }
    }
}