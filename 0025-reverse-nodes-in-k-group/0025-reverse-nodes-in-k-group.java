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
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        curr = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevTail = dummy;
        while(len >= k){
            ListNode start = prevTail.next;
            ListNode nextStart = start;
            for(int i = 0; i < k; i++){
                nextStart = nextStart.next;
            }
            ListNode prev = nextStart;
            curr = start;
            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevTail.next = prev;
            prevTail = start;
            len -= k;
        }
        return dummy.next;
    }
}