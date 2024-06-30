class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newH = new int[heights.length + 1];
        Stack<Integer> stack = new Stack<>();
        System.arraycopy(heights, 0, newH, 0, heights.length);
        int largestRec = 0;
        for(int i = 0; i < newH.length; i++){
            while(!stack.isEmpty() && newH[i] < newH[stack.peek()]){
                int height = newH[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                largestRec = Math.max(largestRec, width * height);
            }
            stack.push(i);
        }
        return largestRec;
    }
}