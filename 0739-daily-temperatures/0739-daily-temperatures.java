class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoStack = new Stack<>();
        int[] result = new int[temperatures.length];
        monoStack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!monoStack.isEmpty() && temperatures[i] > temperatures[monoStack.peek()]){
                result[monoStack.peek()] = i - monoStack.peek();
                monoStack.pop();
            }
                monoStack.push(i);
        }
        return result;
    }
}