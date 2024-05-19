class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) {
            return false;
        }
        int target = totalLength / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);  // Sort in descending order
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, target, 0);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int target, int index) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if (backtrack(matchsticks, sides, target, index + 1)) {
                    return true;
                }
                sides[i] -= matchsticks[index];  // backtrack
            }
            if (sides[i] == 0) {
                break;  // Optimization: skip redundant tries
            }
        }
        return false;
    }

    private void reverse(int[] matchsticks) {
        int left = 0, right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
}

