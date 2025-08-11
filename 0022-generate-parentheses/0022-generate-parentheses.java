class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int n, int left, int right){
        if(sb.length() == n * 2) res.add(sb.toString());
        if(left < n){
            sb.append('(');
            backtrack(res, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            backtrack(res, sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}