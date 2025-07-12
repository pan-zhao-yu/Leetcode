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
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;
            //swap
            n1.next = n2.next;
            n2.next = n1;
            curr.next = n2;
            //move curr
            curr = n1;
        }
        return dummy.next;
    }
}

// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode dummy = new ListNode(0, head);
//         ListNode curr = dummy;
//         ListNode prev = dummy;
//         while(curr.next != null && curr.next.next != null){
//             ListNode next = curr.next.next.next;
//             ListNode n1 = curr.next;
//             ListNode n2 = curr.next.next;
//             prev.next = n2;
//             curr = curr.next;
//             curr.next = n1;
//             curr = curr.next;
//             curr.next = next;
//             prev = curr;
//         }
//         return dummy.next;
//     }
// }