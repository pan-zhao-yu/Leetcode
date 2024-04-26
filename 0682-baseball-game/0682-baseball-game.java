class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        int result = 0;
        for(String operation : operations){
            if(operation.equals("+") && scores.size() >= 2){
                int s1 = scores.pop();
                int s2 = scores.peek();
                scores.push(s1);
                scores.push(s2 + s1);
            }else if(operation.equals("D") && !scores.isEmpty()){
                scores.push(scores.peek() * 2);
            }else if(operation.equals("C") && !scores.isEmpty()){
                scores.pop();
            }else{
                scores.push(Integer.parseInt(operation));
            }
        }
        while(!scores.isEmpty()){
            result += scores.pop();
        }
        return result;
    }
}
