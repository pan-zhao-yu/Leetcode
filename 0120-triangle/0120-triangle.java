class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int miniPath = 0;
        for(int row = triangle.size() - 2; row >= 0; row--){
            for(int col = 0; col < triangle.get(row).size(); col++){
                miniPath = triangle.get(row).get(col) + 
                    Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, miniPath);
            }
        }
        return triangle.get(0).get(0);
    }
}