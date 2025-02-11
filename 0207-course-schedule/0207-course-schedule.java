class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjacent.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            adjacent.get(prerequisite[0]).add(prerequisite[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(isCircle(adjacent, visited, i)) return false;
            }
        }
        return true;
    }

    private boolean isCircle(List<List<Integer>> adjacent, int[] visited, int curr){
        if(visited[curr] == 2) return true;
        if(visited[curr] == 1) return false;
        visited[curr] = 2;
        for(int pre : adjacent.get(curr)){
            if(isCircle(adjacent, visited, pre)) return true;
        }
        visited[curr] = 1;
        return false;
    }
}