class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i = 1;
        while(i < prices.length){
            if(prices[i] > prices[i -1]){
                max += prices[i] - prices[i -1];
            }
            i++;
        }
        return max;
    }
}