class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtrack(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}



// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> list = new ArrayList<>();
//         backtrack(list, new ArrayList<>(), nums);
//         return list;
//     }
    
//     private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums){
//         if(temp.size() == nums.length){
//             list.add(new ArrayList(temp));
//         }else{
//             for(int i = 0; i < nums.length; i++){
//                 if(temp.contains(nums[i])) continue;
//                 temp.add(nums[i]);
//                 backtrack(list, temp, nums);
//                 temp.remove(temp.size() - 1);
//             }
//         }
//     }
// }