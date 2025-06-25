class Solution {
    public int[][] generateMatrix(int n) {
        int x = 0, y = 0, dx = 1, dy = 0;
        int[][] res = new int[n][n];
        for(int i = 0; i < n * n; i++){
            res[y][x] = i + 1;
            if(!(x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < n) || res[y + dy][x + dx] != 0){
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

// class Solution {
//     public int[][] generateMatrix(int n) {
//         int[][] matrix = new int[n][n];
//         int top = 0, bottom = n - 1, left = 0, right = n - 1;
//         int num = 1;

//         while (top <= bottom && left <= right) {
//             // Move right
//             for (int i = left; i <= right; i++) {
//                 matrix[top][i] = num++;
//             }
//             top++;

//             // Move down
//             for (int i = top; i <= bottom; i++) {
//                 matrix[i][right] = num++;
//             }
//             right--;

//             // Move left
//             if (top <= bottom) {
//                 for (int i = right; i >= left; i--) {
//                     matrix[bottom][i] = num++;
//                 }
//                 bottom--;
//             }

//             // Move up
//             if (left <= right) {
//                 for (int i = bottom; i >= top; i--) {
//                     matrix[i][left] = num++;
//                 }
//                 left++;
//             }
//         }

//         return matrix;
//     }
// }