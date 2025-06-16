class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) k = k * 10 + (c - '0');
            else if(c == '['){
                countStack.push(k);
                k = 0;
                stringStack.push(sb);
                sb = new StringBuilder();
            }else if(c == ']'){
                int repeat = countStack.pop();
                StringBuilder curr = stringStack.pop();
                for(int i = 0; i < repeat; i++){
                    curr.append(sb);
                }
                sb = curr;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}