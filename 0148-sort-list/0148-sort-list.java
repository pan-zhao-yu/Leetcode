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
        if(head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right;
        right = right.next;
        temp.next = null;
        left = sortList(left);
        right = sortList(right);
        return sort(left, right);
    }
    private ListNode getMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode sort(ListNode n1, ListNode n2){
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                res.next = n1;
                n1 = n1.next;
            }else{
                res.next = n2;
                n2 = n2.next;
            }
            res = res.next;
        }
        if(n1 != null) res.next = n1;
        if(n2 != null) res.next = n2;
        return dummy.next;
    }
}