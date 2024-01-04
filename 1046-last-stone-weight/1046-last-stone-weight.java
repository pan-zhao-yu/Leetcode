class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            
            if(stone1 != stone2){
                maxHeap.offer(Math.abs(stone1 - stone2));
            }
        }
        return maxHeap.isEmpty()? 0: maxHeap.poll();
    }
}