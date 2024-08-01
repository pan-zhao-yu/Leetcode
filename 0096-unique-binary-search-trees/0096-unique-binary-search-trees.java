class Solution {
    
    public int numTrees(int n) {
        int x = 0;
        if(n == 0){
            return 1;
        }
        if(n == 1) return 1;
        
        for(int i = 0; i <= n - 1; i++){
            x += numTrees(i) * numTrees(n - 1 - i);
        }
        return x;
    }
}



// class Solution {
//     public int numTrees(int n) {
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;
//         for(int i = 2; i <= n; i++){
//             for(int j = 1; j <= i; j++){
//                 dp[i] += dp[j - 1] * dp[i - j];
//             }
//         }
//         return dp[n];
//     }
// }
//dp[i] = dp[j - 1] * dp[i - j];