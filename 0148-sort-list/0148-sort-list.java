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
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode sort(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                head.next = left;
                left = left.next;
            }else{
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if(left != null){
            head.next = left;
        }
        if(right != null){
            head.next = right;
        }
        return dummy.next;
    }
    
}