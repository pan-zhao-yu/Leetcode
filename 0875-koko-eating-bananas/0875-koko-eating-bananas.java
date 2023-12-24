class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(pile, right);
        }
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int hourNeed = 0;
            
            for(int pile : piles){
                hourNeed += Math.ceil((double)pile / mid);
            }
            
            if(hourNeed <= h){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}