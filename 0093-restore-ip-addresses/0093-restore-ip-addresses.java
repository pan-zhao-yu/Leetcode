class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return result;
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<String> result, List<String> temp, String s, int start){
        if(temp.size() == 4 && start == s.length()){
            result.add(String.join(".", temp));
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(start + i <= s.length()){
                String segment = s.substring(start, start + i);
                if(isValid(segment)){
                    temp.add(segment);
                    backtrack(result, temp, s, start + i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
    
    private boolean isValid(String segment){
        if(segment.length() > 1 && segment.startsWith("0")) return false;
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}
