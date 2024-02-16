class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        
        int resLen = 0;
        String res = "";
        for(int i = 0; i < len; i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > resLen){
                    res = s.substring(left, right + 1);
                    resLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > resLen){
                    res  = s.substring(left, right +1);
                    resLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }
        }
        return res;
    }
}