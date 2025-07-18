class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            count++;
            for(int pre : graph.get(c)){
                indegree[pre]--;
                if(indegree[pre] == 0) q.add(pre);
            }
        }
        return count == numCourses;
    }
}