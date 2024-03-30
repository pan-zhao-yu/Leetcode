class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacent.add(new ArrayList<>());
        }
        for(int i = 0; i< prerequisites.length; i++){
            adjacent.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(isCyclic(adjacent, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adjacent, int[] visited, int curr){
        if(visited[curr] == 2){
            return true;
        }
        visited[curr] = 2;
        for(int i = 0; i < adjacent.get(curr).size(); i++){
            if(visited[adjacent.get(curr).get(i)] != 1){
                if(isCyclic(adjacent, visited, adjacent.get(curr).get(i))){
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    }
}


// class Solution {

//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < prerequisites.length; i++) {
//             adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
//         }

//         int[] visited = new int[numCourses];
//         for (int i = 0; i < numCourses; i++) {
//             if (visited[i] == 0) {
//                 if (isCyclic(adj, visited, i)) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
//         if (visited[curr] == 2) {
//             return true;
//         }

//         visited[curr] = 2;
//         for (int i = 0; i < adj.get(curr).size(); i++) {
//             if (visited[adj.get(curr).get(i)] != 1) {
//                 if (isCyclic(adj, visited, adj.get(curr).get(i))) {
//                     return true;
//                 }
//             }
//         }
//         visited[curr] = 1;
//         return false;
//     }
// }
