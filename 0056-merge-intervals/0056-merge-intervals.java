class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] curr = intervals[0];
        result.add(curr);
        for(int[] interval : intervals){
            int currEnd = curr[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if(currEnd >= nextStart){
                curr[1] = Math.max(currEnd, nextEnd);
            }else{
                curr = interval;
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}