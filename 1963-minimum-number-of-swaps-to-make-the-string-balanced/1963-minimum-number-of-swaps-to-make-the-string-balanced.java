class Solution {
    public int minSwaps(String s) {
        if(s.length() == 0) return 0;
        int max = 0;
        int extraclosing = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)== ']'){
                extraclosing++;
                max = Math.max(extraclosing, max);
            }else{
                extraclosing--;
            }
        }
        return (max + 1) / 2;
    }
}