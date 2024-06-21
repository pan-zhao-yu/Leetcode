class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(hasApple, graph, 0, -1);
    }
    private int dfs(List<Boolean> hasApple, List<List<Integer>> graph, int curr, int pre){
        int totalTime = 0;
        for(int neighbor : graph.get(curr)){
            if(neighbor == pre) continue;
            int childTime = dfs(hasApple, graph, neighbor, curr);
            if(childTime > 0 || hasApple.get(neighbor)){
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}