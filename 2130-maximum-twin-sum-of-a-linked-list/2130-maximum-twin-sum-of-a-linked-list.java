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
    public int pairSum(ListNode head) {
        ListNode mid = head;
        ListNode right = head;
        int max = 0;
        while(right != null && right.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        
        ListNode prev = null, next = null, curr = mid;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        while(prev != null){
            max = Math.max(max, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }
        
        return max;
    }
}