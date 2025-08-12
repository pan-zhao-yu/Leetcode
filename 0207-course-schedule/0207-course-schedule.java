class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> courseToTake= graph.get(curr);
            for(int n : courseToTake){
                indegree[n]--;
                if(indegree[n] == 0) q.offer(n);
            }
        }
        return count == numCourses;
    }
}