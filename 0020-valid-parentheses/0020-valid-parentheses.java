class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty() || !isValid(stack.pop(), c)) return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    private boolean isValid(char open, char close){
        return (open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']');
    }
}