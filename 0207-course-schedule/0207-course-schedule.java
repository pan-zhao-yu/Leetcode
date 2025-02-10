class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> reqMap = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            reqMap.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            reqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(isCircle(reqMap, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCircle(List<List<Integer>> reqMap, int[] visited, int curr){
        if(visited[curr] == 2) return true;
        visited[curr] = 2;
        for(int i = 0; i < reqMap.get(curr).size(); i++){
            if(visited[reqMap.get(curr).get(i)] != 1){
                if(isCircle(reqMap, visited, reqMap.get(curr).get(i))) return true;
            }
        }
        visited[curr] = 1;
        return false;
    }
}