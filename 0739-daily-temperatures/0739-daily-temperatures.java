class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> minS = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!minS.isEmpty() && temperatures[i] > temperatures[minS.peekFirst()]){
                res[minS.peekFirst()] = i - minS.pollFirst();
            }
            minS.addFirst(i);
        }
        return res;
    }
}