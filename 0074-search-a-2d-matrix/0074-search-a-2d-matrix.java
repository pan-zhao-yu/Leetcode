class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int lineLength = matrix[0].length;
        int left = 0;
        int right = length * lineLength - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / lineLength][mid % lineLength];
            if(target == midValue){
                return true;
            }else if(target < midValue){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        return false;
        
    }
}