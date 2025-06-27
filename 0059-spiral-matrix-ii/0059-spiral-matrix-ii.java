// class Solution {
//     public int[][] generateMatrix(int n) {
//         int[][] res = new int[n][n];
//         int left = 0, right = n - 1, top = 0, bottom = n - 1;
//         int num = 1;
//         while (top <= bottom && left <= right) {
//             for (int i = left; i <= right; i++) {
//                 res[top][i] = num++;
//             }
//             top++;
//             for (int i = top; i <= bottom; i++) {
//                 res[i][right] = num++;
//             }
//             right--;
//             for (int i = right; i >= left; i--) {
//                 res[bottom][i] = num++;
//             }
//             bottom--;
//             for (int i = bottom; i >= top; i--) {
//                 res[i][left] = num++;
//             }
//             left++;
//         }
//         return res;
//     }
// }

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Move right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Move down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Move left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // Move up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
