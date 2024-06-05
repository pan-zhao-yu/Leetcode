class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1]){
                end++;
                i++;
            }
            if(start == end){
                result.add(String.valueOf(nums[start]));
            }else{
                result.add(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;
        }
        return result;
    }
}