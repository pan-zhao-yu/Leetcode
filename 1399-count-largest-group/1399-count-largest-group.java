class Solution {
    public int countLargestGroup(int n) {
        int[] sums = new int[37];
        for(int i = 1; i <= n; i++){
            sums[digitsum(i)]++;
        }
        int max = 0;
        int count = 0;
        for(int sum : sums){
            if(sum > max){
                max = sum;
                count = 1;
            }else if(max == sum){
                count++;
            }
        }
        return count;
    }
// helper method that take a integer and return its digit sum
    private int digitsum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }
}