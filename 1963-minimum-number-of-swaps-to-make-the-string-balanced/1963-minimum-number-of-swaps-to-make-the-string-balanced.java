class Solution {
    public int minSwaps(String s) {
        int max = 0;
        int extraClosing = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']' || s.charAt(i) == '['){
                if(s.charAt(i) == ']'){
                    extraClosing++;
                    max = Math.max(extraClosing, max);
                }else{
                    extraClosing--;
                }
            }
        }
        return (max + 1) / 2;
    }
}