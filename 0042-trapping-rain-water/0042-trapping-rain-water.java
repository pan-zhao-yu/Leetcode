class Solution {
    public int trap(int[] height) {
        int traped = 0;
        int leftM = 0;
        int rightM = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for(int i = 0; i < leftMax.length; i++){
            leftMax[i] = leftM;
            leftM = Math.max(height[i], leftM);
        }
        for(int i = leftMax.length - 1; i >=0; i--){
            rightMax[i] = rightM;
            rightM = Math.max(height[i], rightM);
        }
        for(int i = 0; i < height.length; i++){
            int t = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(t > 0){
                traped += t;
            }
        }
        return traped;
    }
}

// class Solution {
//     public int trap(int[] height) {
//         int left = 0;
//         int right = height.length - 1;;
//         int maxLeft = 0;
//         int maxRight = 0;
//         int trappedWater = 0;
        
//         while(left < right){
//             if(height[left] < height[right]){
//                 maxLeft = Math.max(height[left], maxLeft);
//                 trappedWater += maxLeft - height[left];
//                 left++;
//             }else{
//                 maxRight = Math.max(height[right], maxRight);
//                 trappedWater += maxRight - height[right];
//                 right--;
//             }
//         }
//         return trappedWater;
//     }
// }