class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int hourNeeded = 0;
            for(int pile : piles){
                hourNeeded += Math.ceil((double) pile / mid);
            }
            if(hourNeeded <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}