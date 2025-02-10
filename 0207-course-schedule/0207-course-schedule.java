class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prereqMap = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            prereqMap.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            prereqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(isCircle(prereqMap, visited, i)) return false;
            }
        }  
        return true;      
    }

    private boolean isCircle(List<List<Integer>> prereqMap, int[] visited, int curr){
        if(visited[curr] == 2) return true;
        visited[curr] = 2;
        for(int i = 0; i < prereqMap.get(curr).size(); i++){
            if(visited[prereqMap.get(curr).get(i)] != 1){
                if(isCircle(prereqMap, visited, prereqMap.get(curr).get(i))) return true;
            }
        }
        visited[curr] = 1;
        return false;
    }
}