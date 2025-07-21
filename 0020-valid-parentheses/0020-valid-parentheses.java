class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.addFirst(c);
            else if(!stack.isEmpty()){
                char curr = stack.pollFirst();
                if(curr == '(' && c != ')') return false;
                if(curr == '[' && c != ']') return false;
                if(curr == '{' && c != '}') return false;
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}