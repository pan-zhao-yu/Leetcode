import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        
        Set<Integer> used = new HashSet<>(); // 防止同层重复
        for (int i = start; i < nums.length; i++) {
            // 跳过同层中重复的元素
            if (used.contains(nums[i])) continue;
            
            // 如果当前子序列为空，或者当前元素大于等于子序列的最后一个元素，才能添加
            if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
                used.add(nums[i]);
                temp.add(nums[i]);
                backtrack(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
