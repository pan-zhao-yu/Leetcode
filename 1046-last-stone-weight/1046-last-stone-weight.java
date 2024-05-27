class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            maxHeap.offer(s);
        }
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if(stone1 != stone2){
                maxHeap.offer(stone1 - stone2);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}