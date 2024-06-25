/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }
    
    private Node dfs(int[][] grid, int row, int col, int size){
        if(size == 1) return new Node(grid[row][col] == 1, true, null, null, null, null);
        int newSize = size / 2;
        Node topLeft = dfs(grid, row, col, newSize);
        Node topRight = dfs(grid, row, col + newSize, newSize);
        Node bottomLeft = dfs(grid, row + newSize, col, newSize);
        Node bottomRight = dfs(grid, row + newSize, col + newSize, newSize);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val){
            return new Node(topLeft.val, true, null, null, null, null);
        }else{
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}