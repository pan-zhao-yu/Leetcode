class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k ==0) return result;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for(int j = 0; j < nums2.length && j < k; j++){
            minHeap.add(new int[]{nums1[0], nums2[j], 0});
        }
        while(k > 0 && !minHeap.isEmpty()){
            int[] current = minHeap.poll();
            result.add(Arrays.asList(current[0], current[1]));
            int i = current[2];
            if(i + 1 < nums1.length){
                minHeap.add(new int[]{nums1[1 + i], current[1], i + 1});
            }
            k--;
        }
        return result;
    }
}
