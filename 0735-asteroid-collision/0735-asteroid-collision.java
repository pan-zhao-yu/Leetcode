class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                i++;
            }else{
                if(stack.peek() >= 0 && asteroids[i] < 0){
                    if(Math.abs(stack.peek()) > Math.abs(asteroids[i])){
                        i++;
                    }else if(Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                        stack.pop();
                    }else{
                        stack.pop();
                        i++;
                    }
                }else{
                    stack.push(asteroids[i]);
                    i++;
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int j = stack.size() - 1; j >= 0; j--){
            result[j] = stack.pop();
        }
        return result;
    }
}