class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;
        int m = 0;
        for(int i = 0; i < height.length; i++){
            leftMax[i] = m;
            m = Math.max(m, height[i]);
        }
        m = 0;
        for(int i = height.length - 1; i >= 0; i--){
            rightMax[i] = m;
            m = Math.max(m, height[i]);
        }
        for(int i = 0; i < height.length; i++){
            int curr = Math.min(leftMax[i], rightMax[i]);
            result += Math.max(0, curr - height[i]);
        }
        return result;
    }
}