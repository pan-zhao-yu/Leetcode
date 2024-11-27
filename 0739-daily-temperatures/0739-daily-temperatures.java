class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mono = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!mono.isEmpty() && temperatures[mono.peek()] < temperatures[i]){
                res[mono.peek()] = i - mono.pop();
            }
            mono.push(i);
        }
        return res;
    }
}