class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nums2 = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++){
            nums2[i] = nums[i];
            nums2[i + nums.length] = nums[i];
        }
        
        Stack<Integer> stack = new Stack();
        int[] result = new int[nums2.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                result[stack.peek()] = nums2[i];
                stack.pop();
            }
            stack.push(i);
        }

        int[] realResult = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            realResult[i] = result[i];
        }
        return realResult;
    }
}