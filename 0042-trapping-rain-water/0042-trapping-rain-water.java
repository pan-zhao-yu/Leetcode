class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int mid = st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int left = st.peek();
                int h = Math.min(height[left], height[i]) - height[mid];
                int w = i - left - 1;
                res += h * w;
            }
            st.push(i);
        }
        return res;
    }
}
