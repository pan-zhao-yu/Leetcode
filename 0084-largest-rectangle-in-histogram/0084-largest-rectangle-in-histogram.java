class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        int[] newHeight = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++){
            newHeight[i + 1] = heights[i];
        }
        heights = newHeight;
        heights[0] = 0;
        heights[heights.length - 1] = 0;
        st.push(0);
        for(int i = 1; i < heights.length; i++){
            while(heights[i] < heights[st.peek()]){
                int mid = st.pop();
                if(!st.isEmpty()){
                    int w = i - st.peek() -1;
                    res = Math.max(res, heights[mid] * w);
                }
                
            }
            st.push(i);
        }
        return res;
    }
}