class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet();
        for (Character c: s.toCharArray()) {
            letters.add(c);
        }
        
        int ans = 0;
        for (Character letter : letters) {
            int i = -1;
            int j = 0;
            
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }
                    
                    j = k;
                }
            }
            
            Set<Character> between = new HashSet();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }
            
            ans += between.size();
        }
        
        return ans;
    }
}


// Time Limit Exceeded by using backtracking

// class Solution {
//     int res = 0;

//     public int countPalindromicSubsequence(String s) {
//         StringBuilder temp = new StringBuilder();
//         HashSet<String> find = new HashSet<>(); // Use HashSet for efficiency
//         backtrack(s, find, temp, 0);
//         return res;
//     }

//     private void backtrack(String s, HashSet<String> find, StringBuilder temp, int start) {
//         if (temp.length() == 3) {
//             if (isPalindrom(temp) && !find.contains(temp.toString())) {
//                 find.add(temp.toString());
//                 res++;
//             }
//             return; // Stop further recursion when temp length is 3
//         }

//         for (int i = start; i < s.length(); i++) {
//             temp.append(s.charAt(i));
//             backtrack(s, find, temp, i + 1);
//             temp.deleteCharAt(temp.length() - 1); // Backtrack step
//         }
//     }

//     private boolean isPalindrom(StringBuilder temp) {
//         int left = 0;
//         int right = temp.length() - 1;
//         while (left <= right) {
//             if (temp.charAt(left) != temp.charAt(right)) return false;
//             left++;
//             right--;
//         }
//         return true;
//     }
// }