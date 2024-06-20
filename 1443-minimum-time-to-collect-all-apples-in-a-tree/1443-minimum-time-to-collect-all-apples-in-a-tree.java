
public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Step 1: Build the tree using an adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Step 2: Perform DFS to calculate the minimum time
        return dfs(tree, hasApple, 0, -1);
    }

    private int dfs(List<List<Integer>> tree, List<Boolean> hasApple, int currentNode, int parent) {
        int totalTime = 0;
        
        for (int neighbor : tree.get(currentNode)) {
            if (neighbor == parent) continue; // Skip the parent node to prevent cycling

            int timeFromChild = dfs(tree, hasApple, neighbor, currentNode);
            
            // If the subtree rooted at the child has apples, we need to consider the travel time
            if (timeFromChild > 0 || hasApple.get(neighbor)) {
                totalTime += timeFromChild + 2; // +2 for the round trip to the child node
            }
        }
        
        return totalTime;
    }
}