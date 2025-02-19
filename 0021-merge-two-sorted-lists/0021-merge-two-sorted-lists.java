/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while (list1 != null && list2 != null) {
            int n1 = list1.val;
            int n2 = list2.val;
            if (n1 < n2) {
                ListNode curr = new ListNode(n1);
                tail.next = curr;
                list1 = list1.next;
            } else {
                ListNode curr = new ListNode(n2);
                tail.next = curr;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }
        return res.next;
    }
}