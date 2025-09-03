class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // 当前低谷
                if (stack.isEmpty()) break;
                int left = stack.peek(); // 左边的高墙
                int width = i - left - 1;
                int minHeight = Math.min(height[left], height[i]) - height[bottom];

                res += width * minHeight;
            }
            stack.push(i);
        }
        return res;
    }
}


//Two Pointer

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