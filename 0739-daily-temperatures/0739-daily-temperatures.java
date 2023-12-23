class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> date = new Stack<>();
        int[] result = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++){
            while(!date.isEmpty() && temperatures[i] > temperatures[date.peek()]){
                int preDate = date.pop();
                result[preDate] = i - preDate;
            }
            date.push(i);
        }
        
        return result;
    }
}