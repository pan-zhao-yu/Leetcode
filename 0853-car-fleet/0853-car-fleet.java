class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        
        Arrays.sort(cars,(a,b) -> Integer.compare(b.position, a.position));
        
        Stack<Double> stack = new Stack<>();
        
        for(Car car : cars){
            if(!stack.isEmpty() && car.time <= stack.peek()){
                continue;
            }
            
            stack.push(car.time);
        }
        return stack.size();
        
        
    }
    private class Car{
            int position;
            double time;
            
            private Car(int position, double time){
                this.position = position;
                this.time = time;
            }
        }
}