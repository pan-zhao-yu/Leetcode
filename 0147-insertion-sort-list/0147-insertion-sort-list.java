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
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }

        ListNode dummy = new ListNode(); // Dummy node for the sorted list
        ListNode current = head; // Current node in the original list

        while (current != null) {
            ListNode nextNode = current.next; // Save the next node before modification
            ListNode prev = dummy; // Start from the beginning of the sorted list

            // Find the correct position to insert the current node in the sorted list
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert the current node into the sorted list
            current.next = prev.next;
            prev.next = current;

            // Move to the next node in the original list
            current = nextNode;
        }

        return dummy.next; // Return the sorted list starting from the next of the dummy node
    }
}