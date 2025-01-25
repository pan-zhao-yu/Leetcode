class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = res.get(i - 1);

            currRow.add(1);
            for(int j = 1; j < i; j++){
                currRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            currRow.add(1);
            res.add(currRow);
        }
        return res;
    }
}