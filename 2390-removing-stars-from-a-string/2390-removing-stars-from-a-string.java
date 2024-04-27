class Solution {
    public String removeStars(String s) {
        Stack<Character> chars = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '*'){
                if(!chars.isEmpty()){
                    chars.pop();
                }
            }else{
                chars.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(char c : chars){
            result.append(c);
        }
        return result.toString();
    }
}
