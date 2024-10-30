class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int waterTrapped = 0;
        
        for(int i = 0; i < height.length; i++){
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }
        for(int i = height.length - 1; i >= 0; i--){
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }
        
        for(int i = 0; i < height.length; i++){
            int border = Math.min(left[i], right[i]);
            waterTrapped += Math.max(0, border - height[i]);
        }
        return waterTrapped;
    }
}