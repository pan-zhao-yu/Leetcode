class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int left = 0;
        int right = 0;
        while(right < prices.length){
            if(prices[right] > prices[left]){
                maxP = Math.max(prices[right] - prices[left], maxP);
            }else{
                left = right;
            }
            right++;
        }
        return maxP;
    }
}