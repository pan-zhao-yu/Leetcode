public class Solution {
    public String reverseWords(String s) {
        // Trim and split the string by one or more spaces
        String[] words = s.trim().split("\\s+");

        // Reverse the order of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        // Remove the last extra space and return the result
        return reversed.toString().trim();
    }
}
