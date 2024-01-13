class Solution {
    public int arrangeCoins(int n) {
        return check(n);
    }
    
    private int check(int num){
        int stair = 0;
        int cost = 1;
        while(num >= cost){
            stair++;
            num -= cost;
            cost ++;
        }
        return stair;
    }
}