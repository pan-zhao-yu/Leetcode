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
        if (head == null || head.next == null || k == 0)
            return head;

        int l = 1; // length of list
        ListNode temp = head;

        // calculate the list's length
        while (temp.next != null) {
            l++;
            temp = temp.next;
        }

        temp.next = head; // make the list cyclic
        k = k % l; // handles the case where k>l
        k = l - k;

        while (k > 0) {
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}