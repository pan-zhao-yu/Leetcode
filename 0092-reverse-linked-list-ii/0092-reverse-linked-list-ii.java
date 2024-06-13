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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int i = 0;
        while(i < left - 1){
            curr = curr.next;
            i++;
        }
        ListNode start = curr.next;
        ListNode then = start.next;
        for(i = 0; i < right - left; i++){
            start.next = then.next;
            then.next = curr.next;
            curr.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}