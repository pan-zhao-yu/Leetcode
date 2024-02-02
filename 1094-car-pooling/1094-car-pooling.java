class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline = new int[1001];
        
        for(int[] trip : trips){
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            timeline[start] += passengers;
            timeline[end] -= passengers;
        }
        int currentPass = 0;
        for(int passengersChange : timeline){
            currentPass += passengersChange;
            if(currentPass> capacity){
                return false;
            }
        }
        return true;
    }
}