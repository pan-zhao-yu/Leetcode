class Solution {
    private static final String[] KEYPAD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder temp, String digits, int start){
        if(start == digits.length()){
            result.add(temp.toString());
            return;
        }
        String letters = KEYPAD[digits.charAt(start) - '0'];
        for(char letter : letters.toCharArray()){
            temp.append(letter);
            backtrack(result, temp, digits, start + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
