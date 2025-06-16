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
