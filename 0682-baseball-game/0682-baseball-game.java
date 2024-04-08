class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        if (operations.length == 0) return 0;
        for(String op : operations){
            if(op.equals("+") && stack.size() >= 2){
                int score1 = stack.pop();
                int score2 = stack.peek();
                stack.push(score1);
                stack.push(score1 + score2);
            }else if(op.equals("D") && !stack.isEmpty()){
                int score = stack.peek();
                stack.push(score * 2);
            }else if(op.equals("C") && !stack.isEmpty()){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}

