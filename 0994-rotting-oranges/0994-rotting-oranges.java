import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0; // 新鲜橘子数量
        int time = 0;  // 腐烂传播所需时间
        Queue<int[]> q = new LinkedList<>(); // 队列用于 BFS
        
        // 初始化队列和新鲜橘子的数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j}); // 将腐烂橘子加入队列
                } else if (grid[i][j] == 1) {
                    fresh++; // 统计新鲜橘子数量
                }
            }
        }
        
        // 如果没有新鲜橘子，直接返回 0
        if (fresh == 0) {
            return 0;
        }
        
        // 方向数组，用于简化上下左右的遍历
        int[][] directions = {
            {-1, 0}, // 上
            {1, 0},  // 下
            {0, -1}, // 左
            {0, 1}   // 右
        };
        
        // BFS 开始
        while (!q.isEmpty()) {
            int size = q.size(); // 当前层的节点数量
            
            // 处理当前层的所有节点
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    
                    // 检查边界和是否是新鲜橘子
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2; // 将新鲜橘子标记为腐烂
                        fresh--; // 新鲜橘子数量减少
                        q.add(new int[]{x, y}); // 将新腐烂的橘子加入队列
                    }
                }
            }
            
            // 如果队列不为空，说明还有腐烂传播，增加时间
            if (!q.isEmpty()) {
                time++;
            }
        }
        
        // 如果还有新鲜橘子，返回 -1，否则返回时间
        return fresh == 0 ? time : -1;
    }
}
