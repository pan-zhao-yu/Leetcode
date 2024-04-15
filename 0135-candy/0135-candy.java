class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int[] nums = new int[ratings.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = 1;
        }
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
        }
        for(int i = ratings.length - 1; i > 0; i--){
            if(ratings[i] < ratings[i - 1]){
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            result += nums[i];
        }
        return result;
    }
}