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
    public ListNode sortList(ListNode head) {
        if(head  == null || head.next == null) return head;
        ListNode left = head, right = head, temp = head.next;
        while(temp != null && temp.next != null){
            temp = temp.next.next;
            right = right.next;
        }
        ListNode next = right.next;
        right.next = null;
        right = next;
        ListNode sortedL = sortList(left);
        ListNode sortedR = sortList(right);
        return sort(sortedL, sortedR);
    }

    private ListNode sort(ListNode l, ListNode r){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l != null && r != null){
            if(l.val < r.val){
                curr.next = l;
                l = l.next;
            }else{
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if(l != null) curr.next = l;
        if(r != null) curr.next = r;
        return dummy.next;
    }

}