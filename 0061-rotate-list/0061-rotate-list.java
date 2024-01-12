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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 ) return head;
        ListNode fast = head, slow = head, dummy = head;
        int newK = 0;
        while(dummy != null){
            dummy = dummy.next;
            newK++;
        }
        newK = k % newK;
        if(newK == 0) return head;
        
        while(newK > 0){
            fast = fast.next;
            newK--; 
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}