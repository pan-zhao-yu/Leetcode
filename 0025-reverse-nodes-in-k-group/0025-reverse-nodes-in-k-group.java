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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        ListNode start = head;
        ListNode prevTail = dummy;
        while(len >= k){
            curr = start;

            ListNode nextStart = start;
            for(int i = 0; i < k; i++){
                nextStart = nextStart.next;
            }
            ListNode prev = nextStart;
            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevTail.next = prev;
            prevTail = start;
            start = nextStart;
            len -= k;
        }
        return dummy.next;
    }
}