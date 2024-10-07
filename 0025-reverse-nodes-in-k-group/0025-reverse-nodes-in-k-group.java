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
        ListNode temp = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = head;
        temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        ListNode prevTail = dummy;
        while(len >= k){

            ListNode start = prevTail.next;
            ListNode nextHead = start;
            for(int i = 0; i < k; i++){
                nextHead = nextHead.next;
            }
            ListNode curr = start;
            ListNode prev = nextHead;
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