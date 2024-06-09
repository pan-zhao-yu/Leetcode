class Solution {
    public int calculate(String s) {
        int currNum = 0;
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                currNum = currNum * 10 + (c - '0');
            }else if(c == '+'){
                result += currNum * sign;
                currNum = 0;
                sign = 1;
            }else if(c == '-'){
                result += currNum * sign;
                currNum = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += currNum * sign;
                currNum = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * currNum;
        return result;
    }
}