class Solution {
    public String simplifyPath(String path) {
        String[] addresses = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String address : addresses){
            if(address.equals("") || address.equals(".")){
                continue;
            }else if(address.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(address);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String dir : stack){
            result.append("/").append(dir);
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}