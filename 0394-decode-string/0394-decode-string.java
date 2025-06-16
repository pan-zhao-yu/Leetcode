// Recursive solution
class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))) k = k * 10 + (s.charAt(index) - '0');
            else if(s.charAt(index) == '['){
                index++;
                String sub = decodeString(s);
                for(int i = 0; i < k; i++){
                    result.append(sub);
                }
                k = 0;
            }else if(s.charAt(index) == ']'){
                return result.toString();
            }else{
                result.append(s.charAt(index));
            }
            index++;
        }
        return result.toString();
    }
}

// Stack solution

// class Solution {
//     public String decodeString(String s) {
//         Deque<Integer> countStack = new ArrayDeque<>();
//         Deque<StringBuilder> stringStack = new ArrayDeque<>();
//         StringBuilder sb = new StringBuilder();
//         int k = 0;

//         for(char c : s.toCharArray()){
//             if(Character.isDigit(c)) k = k * 10 + (c - '0');
//             else if(c == '['){
//                 countStack.push(k);
//                 k = 0;
//                 stringStack.push(sb);
//                 sb = new StringBuilder();
//             }else if(c == ']'){
//                 int repeat = countStack.pop();
//                 StringBuilder curr = stringStack.pop();
//                 for(int i = 0; i < repeat; i++){
//                     curr.append(sb);
//                 }
//                 sb = curr;
//             }else{
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
// }