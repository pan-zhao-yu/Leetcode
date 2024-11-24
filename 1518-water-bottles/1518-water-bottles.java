class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            int exchanged = empty / numExchange;
            result += exchanged;
            int emptyLeft = empty % numExchange;
            empty = exchanged + emptyLeft;
        }
        return result;
    }
}