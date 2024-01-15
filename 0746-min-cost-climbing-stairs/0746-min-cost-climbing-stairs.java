class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int i = cost.length -1; i >= 0; i --){
            cost[i] += Math.min(a, b);
            a = b;
            b = cost[i];
        }
        
        return Math.min(cost[0],cost[1]);
    }
}