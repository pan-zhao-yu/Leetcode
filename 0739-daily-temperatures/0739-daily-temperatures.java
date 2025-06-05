class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Deque<Integer> stack = new ArrayDeque<>();
         int[] res = new int[temperatures.length];
         for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
         }
         return res;
    }
}