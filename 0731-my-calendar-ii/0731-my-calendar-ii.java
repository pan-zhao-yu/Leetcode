class MyCalendarTwo {
    List<int[]> calendar; // 存储所有的预约区间
    List<int[]> overlap;  // 存储所有的双重重叠区间

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlap = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // 检查是否会导致三重重叠
        if (overlaped(startTime, endTime)) {
            return false;
        }
        // 更新双重重叠区间
        updateOverlap(startTime, endTime);
        // 添加到预约区间
        calendar.add(new int[]{startTime, endTime});
        return true;
    }

    // 检查是否存在三重重叠
    private boolean overlaped(int start, int end) {
        for (int[] interval : overlap) {
            // 如果当前区间与任何双重重叠区间有交集，则返回 true
            if (Math.max(interval[0], start) < Math.min(interval[1], end)) {
                return true;
            }
        }
        return false;
    }

    // 更新双重重叠区间
    private void updateOverlap(int start, int end) {
        for (int[] interval : calendar) {
            // 计算当前区间和已有预约区间的交集
            int overlapStart = Math.max(interval[0], start);
            int overlapEnd = Math.min(interval[1], end);
            if (overlapStart < overlapEnd) {
                // 如果存在交集，将其加入双重重叠列表
                overlap.add(new int[]{overlapStart, overlapEnd});
            }
        }
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */