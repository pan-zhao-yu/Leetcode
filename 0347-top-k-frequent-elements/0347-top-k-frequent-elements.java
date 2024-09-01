class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] topK = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()){
            topK[index++] = minHeap.poll().getKey();        
        }
        return topK;
    }
}