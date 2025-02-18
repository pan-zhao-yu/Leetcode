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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while(l1 != null || l2 != null || carry != 0){
            int digit1 = l1 == null ? 0 : l1.val;
            int digit2 = l2 == null ? 0 : l2.val;
            int curr = digit1 + digit2 + carry;
            carry = curr / 10;
            int n = curr % 10;
            tail.next = new ListNode(n);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            tail = tail.next;
        }
        return res.next;
    }
}