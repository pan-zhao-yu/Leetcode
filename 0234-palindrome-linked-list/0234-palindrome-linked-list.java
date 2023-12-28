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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode left = head, right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }
        
        ListNode pre = null, next;
        while(left != null){
            next = left.next;
            left.next = pre;
            pre = left;
            left = next;
        }
        
        while(pre != null && head != null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
        
    }
}