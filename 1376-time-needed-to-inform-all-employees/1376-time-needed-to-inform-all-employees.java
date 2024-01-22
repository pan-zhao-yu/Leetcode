class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
// Create a map to represent the hierarchy
        Map<Integer, List<Integer>> hierarchy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hierarchy.containsKey(manager[i])) {
                hierarchy.put(manager[i], new ArrayList<>());
            }
            hierarchy.get(manager[i]).add(i);
        }

        // Start DFS from the head manager
        return dfs(headID, hierarchy, informTime);
    }

    private int dfs(int currentEmployee, Map<Integer, List<Integer>> hierarchy, int[] informTime) {
        // Base case: if the current employee has no subordinates
        if (!hierarchy.containsKey(currentEmployee)) {
            return 0;
        }

        // Initialize maxTime to track the maximum time taken at the current level
        int maxTime = 0;

        // Recursively calculate the time for each subordinate
        for (int subordinate : hierarchy.get(currentEmployee)) {
            maxTime = Math.max(maxTime, dfs(subordinate, hierarchy, informTime));
        }

        // Return the total time needed for the current employee and its subordinates
        return maxTime + informTime[currentEmployee];
    }
}