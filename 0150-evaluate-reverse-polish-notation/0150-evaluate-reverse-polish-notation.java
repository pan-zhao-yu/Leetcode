class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int val1;
        int val2;
        
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                val1 = stack.pop();
                val2 = stack.pop();
                stack.push(val2 - val1);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                val1 = stack.pop();
                val2 = stack.pop();
                stack.push(val2 / val1);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}