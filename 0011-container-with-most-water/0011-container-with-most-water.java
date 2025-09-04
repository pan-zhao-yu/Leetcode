class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int curr = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curr);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}