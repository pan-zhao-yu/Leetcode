class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;;
        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                maxLeft = Math.max(height[left], maxLeft);
                trappedWater += maxLeft - height[left];
                left++;
            }else{
                maxRight = Math.max(height[right], maxRight);
                trappedWater += maxRight - height[right];
                right--;
            }
        }
        return trappedWater;
    }
}