class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] edge = new int[26];
        for(int i = 0; i < s.length(); i++){
            edge[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int boundry = 0;
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            boundry = Math.max(boundry, edge[s.charAt(i) - 'a']);
            if(boundry == i){
                res.add(i - prev);
                prev = i;
            }
        }
        return res;
    }
}