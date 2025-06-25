class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int x = 0, y = 0, dx = 1, dy = 0;
        for(int i = 0; i < matrix.length * matrix[0].length; i++){
            res.add(matrix[y][x]);
            matrix[y][x] = -101;
            if(!(x + dx >= 0 && x + dx < matrix[0].length && y + dy >= 0 && y + dy < matrix.length) || matrix[y+dy][x+dx] == -101){
                int temp = dx;
                dx = -dy;
                dy = temp;
            }
            x += dx;
            y += dy;
        }
        return res;
    }
}