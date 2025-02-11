class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        int[] visited = new int[numCourses];
        
        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacent.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] prerequisite : prerequisites) {
            adjacent.get(prerequisite[1]).add(prerequisite[0]); // Note the order here
        }
        
        // Check each course for cycles
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCircle(adjacent, visited, i)) return false;
            }
        }
        return true;
    }

    private boolean isCircle(List<List<Integer>> adjacent, int[] visited, int curr) {
        if (visited[curr] == 2) return true; // Cycle detected
        if (visited[curr] == 1) return false; // Already processed
        
        visited[curr] = 2; // Mark as visiting
        for (int neighbor : adjacent.get(curr)) {
            if (isCircle(adjacent, visited, neighbor)) return true;
        }
        visited[curr] = 1; // Mark as visited
        return false;
    }
}