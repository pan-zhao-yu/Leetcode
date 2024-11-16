class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, minHeight * width);
            System.out.println(maxArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}