class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] event : calendar){
            if(event[0] < endTime && event[1] > startTime){
                return false;
            }
        }
        calendar.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */