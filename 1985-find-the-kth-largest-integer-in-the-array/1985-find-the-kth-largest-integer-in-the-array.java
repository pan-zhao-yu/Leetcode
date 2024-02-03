class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> compare(a, b));
        for(String num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    
    private int compare(String a, String b){
        if(a.length() != b.length()){
            return a.length() - b.length();
        }else{
            return a.compareTo(b);
        }
    }
}