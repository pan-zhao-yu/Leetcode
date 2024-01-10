public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        // Check if out of bounds or not the same color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }

        // Fill the color
        image[sr][sc] = newColor;

        // Recursively call fill for adjacent pixels
        fill(image, sr - 1, sc, color, newColor); // up
        fill(image, sr + 1, sc, color, newColor); // down
        fill(image, sr, sc - 1, color, newColor); // left
        fill(image, sr, sc + 1, color, newColor); // right
    }
}
