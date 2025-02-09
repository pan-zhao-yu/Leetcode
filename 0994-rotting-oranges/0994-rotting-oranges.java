class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while(!q.isEmpty() && fresh != 0){
            time++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                        if(grid[x][y] == 1){
                            grid[x][y] = 2;
                            q.add(new int[]{x, y});
                            fresh--;
                        }
                    }
                }
            }
            if(fresh == 0) return time;
        }
        return fresh == 0 ? time : -1;
    }
}