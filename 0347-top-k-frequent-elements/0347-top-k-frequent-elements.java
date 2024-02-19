class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; --i){
            res[i] = heap.poll();
        }
        return res;
    }
}



// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
//         for (int num : map.keySet()) {
//             heap.add(num);
//             if (heap.size() > k) heap.poll();
//         }

//         int[] topK = new int[k];
//         for (int i = k - 1; i >= 0; --i) {
//             topK[i] = heap.poll();
//         }
//         return topK;
//     }
// }
