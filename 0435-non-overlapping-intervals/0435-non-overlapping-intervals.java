class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort the intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlapping interval found, increment count
                count++;
            } else {
                // No overlap, update the end time
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }
}