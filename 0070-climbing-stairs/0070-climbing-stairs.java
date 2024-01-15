class Solution {
    public int climbStairs(int n) {
        int step1 = 1, step2 = 1;
        int temp = 0;
        for(int i = 0; i < n - 1; i++){
            temp = step1 + step2;
            step2 = step1;
            step1 = temp;
        }
        return step1;
    }
}