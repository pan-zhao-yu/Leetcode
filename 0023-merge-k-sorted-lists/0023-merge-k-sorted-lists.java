/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null){
                queue.offer(node);
            }  
        }
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            
            if(temp.next != null){
                queue.offer(temp.next);
            }
        }
        return dummy.next;
    }
}