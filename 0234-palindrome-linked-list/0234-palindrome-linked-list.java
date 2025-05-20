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
        if(head == null) return true;
        ListNode right = head;
        ListNode mid = head;
        while(right != null && right.next != null){
            right = right.next.next;
            mid = mid.next;
        }
        ListNode prev = null;

        while(mid != null){
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }
        while(prev != null && head != null){
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}