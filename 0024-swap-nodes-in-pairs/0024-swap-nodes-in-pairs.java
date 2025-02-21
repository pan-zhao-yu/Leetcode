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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null && head.next != null){
            ListNode curr1 = head;
            ListNode curr2 = head.next;
            ListNode end = head.next.next;
            curr1.next = end;
            curr2.next = curr1;
            head = end;
            prev.next = curr2;
            prev = curr1;
        }
        return dummy.next;
    }
}