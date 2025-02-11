class Solution {
    public boolean canJump(int[] nums) {
        int currMaxReachable = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > currMaxReachable) return false;
            currMaxReachable = Math.max(currMaxReachable, i + nums[i]);
        }
        return true;
    }
}