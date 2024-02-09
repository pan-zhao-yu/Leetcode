class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int n, int k, int start){
        if(k == 0){
            list.add(new ArrayList(temp));
            return;
        }
        
        for(int i = start; i <= n; i++){
            temp.add(i);
            backtrack(list, temp, n, k -1, i +1);
            temp.remove(temp.size() -1);
        }
    }
}