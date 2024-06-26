class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0) return 1;
        int[] map = new int[n + 1];
        for(int[] t : trust){
            map[t[0]]--;
            map[t[1]]++;
        }
        for(int i = 0; i <= n; i++){
            if(map[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}


// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         Map<Integer, Integer> trustTo = new HashMap<>();
//         Map<Integer, Integer> trustBy = new HashMap<>();
//         for(int[] t : trust){
//             trustTo.put(t[0], trustTo.getOrDefault(t[0], 0) + 1);
//             trustBy.put(t[1], trustBy.getOrDefault(t[1], 0) + 1);
//         }
//         for (int i = 1; i <= n; i++) {
//             // A potential judge should not trust anyone (trustTo should be 0 or not present in the map)
//             if (!trustTo.containsKey(i) || trustTo.get(i) == 0) {
//                 // A potential judge should be trusted by everyone else (n-1 people)
//                 if (trustBy.getOrDefault(i, 0) == n - 1) {
//                     return i;
//                 }
//             }
//         }
//         return -1;
//     }
// }