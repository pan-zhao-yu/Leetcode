class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//(a, b) -> a[0] - b[0]
        for(int[] interval : intervals){
            if(result.size() != 0 && result.get(result.size() - 1)[1] >= interval[0]){
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }else{
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}