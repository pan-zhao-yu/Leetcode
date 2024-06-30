class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate trapped water
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return trapped;
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