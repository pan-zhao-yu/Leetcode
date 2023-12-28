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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode next, prev = null;
        while(slow != null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        ListNode first = head, second = prev;
        while(second.next != null) {
            next = first.next;
            first.next = second;
            first = second;
            second = next;
        }

        
    }
}