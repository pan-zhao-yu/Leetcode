class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k) minHeap.poll();
        }
        int[] res = new int[minHeap.size()];
        int index = minHeap.size() - 1;
        while(index >= 0){
            res[index] = minHeap.poll().getKey();
            index--;
        }
        return res;
    }
}