class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int mid = 0;
        int result = 0;
        while(left <= right){
            mid = left + (right - left) /2;
            
            if((long)mid * mid <= x){
                result = mid;
                left = mid + 1;
            }else if((long)mid * mid > x){
                right = mid - 1;
            }
        }
        
        return result;
    }
}