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
        ListNode result = reverse(head, null);
        return result;
    }
    private ListNode reverse(ListNode curr, ListNode pre){
        if(curr == null){
            return pre;
        }
        ListNode temp = curr.next;
        curr.next = pre;
        return reverse(temp, curr);
    }
}