public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);         // Moves 1 step
            fast = sumOfSquares(sumOfSquares(fast)); // Moves 2 steps
        } while (slow != fast);

        return slow == 1; // If slow is 1, then we've found a happy number
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
