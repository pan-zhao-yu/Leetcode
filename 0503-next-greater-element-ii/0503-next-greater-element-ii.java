class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            int currentIndex = i % nums.length;
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                result[stack.pop()] = nums[currentIndex];
            }
            if (i < nums.length) {
                stack.push(currentIndex);
            }
        }
        return result;
    }
}
