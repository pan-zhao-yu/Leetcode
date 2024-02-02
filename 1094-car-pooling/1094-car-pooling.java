class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline = new int[1001]; // Timeline for 0 to 1000 stops
        
        // Update timeline with passengers getting on and off at each stop
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            // Add passengers at start and subtract passengers at end
            timeline[start] += passengers;
            timeline[end] -= passengers;
        }
        
        // Check capacity at each stop
        int currentPassengers = 0;
        for (int passengersChange : timeline) {
            currentPassengers += passengersChange;
            if (currentPassengers > capacity) {
                return false; // Exceeds capacity
            }
        }
        
        return true; // Capacity not exceeded at any stop
    }
}