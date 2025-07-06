class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);
        for(int i = 0; i < intervals.length; i++){
            int nextEnd = intervals[i][1];
            int nextStart = intervals[i][0];
            int currEnd = curr[1];
            if(nextStart <= currEnd){
                curr[1] = Math.max(currEnd, nextEnd);
            }else{
                curr = intervals[i];
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}