class Solution {
    public int removeDuplicates(int[] nums) {
        int newLength = 0;
        for(int num : nums){
            if(newLength < 2 || num > nums[newLength -2]){
                nums[newLength] = num;
                newLength++;
            }
        }
        return newLength;
    }
}