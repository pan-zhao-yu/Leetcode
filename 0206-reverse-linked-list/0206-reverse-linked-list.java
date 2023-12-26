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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode nextCurrent = null;
        ListNode privous = null;
        
        while(current != null){
            nextCurrent = current.next;
            current.next = privous;
            privous = current;
            current = nextCurrent;
        }
        return privous;
    }
}