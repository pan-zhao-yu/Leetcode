class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i += k * 2){
            int l = i, r = Math.min(c.length - 1, i + k - 1);
            reverse(c, l, r);
        }
        return new String(c);
    }
    private void reverse(char[] c, int l, int r){
        while(l < r){
            char temp = c[l];
            c[l] = c[r];
            c[r] = temp;
            l++;
            r--;
        }
    }
}